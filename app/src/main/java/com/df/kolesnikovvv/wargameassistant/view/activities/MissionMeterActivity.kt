package com.df.kolesnikovvv.wargameassistant.view.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.entity.GamePoints
import kotlinx.android.synthetic.main.activity_mission_meter.*
import android.content.res.ColorStateList
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.EditText
import com.df.kolesnikovvv.wargameassistant.MissionMeterContract
import com.df.kolesnikovvv.wargameassistant.entity.SecondaryMissionVp
import com.df.kolesnikovvv.wargameassistant.entity.TurnVp
import com.df.kolesnikovvv.wargameassistant.presenter.MissionMeterPresenter
import com.df.kolesnikovvv.wargameassistant.view.adapters.SecondaryMissionsAdapter

/**
 * Логика сохранения данных
 * данные пишем в SharedPreferences, схема данных для сохранения в классе GamePoints
 *
 * SET при себе забираем из SP значения по ключу каждого чекбокса (0 или 1), выставляем эти значения в класс и из класса инициализируем состояние isChecked чекбокса
 * UPDATE при клике на чекбокс обновляем соответствующее значение класса
 * RESET при ресете зануляем значения класса
 * SAVE при onStop пишем значения из класса в SP с соответствующими ключами
 *
 * SET при сете значений ET достаем строку из SP, парсим в 2 массива и выставляем эти значения в класс. Из класса инициализируем текст
 * UPDATE при изменении значения ET меняем значение статичного поля класса GamePoints (из текстВотчера нет доступа в преференсы)
 * RESET ресете заносим пустые строки в соответствующие элементы массива класса
 * SAVE при onStop парсим массивы значений класса в строку и пишем в SP с ключом gameData
 **/
class MissionMeterActivity : BaseActivity(), MissionMeterContract.View {

    private var presenter: MissionMeterContract.Presenter? = null
    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar)}
    private lateinit var recyclerView: RecyclerView

    private lateinit var myNameEt: EditText
    private lateinit var oppNameEt: EditText


    override fun getToolbarInstance(): Toolbar? = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_meter)

        presenter = MissionMeterPresenter(this, this)

        getToolbarInstance()
        fixStatusBar()

        fab.setOnClickListener {
            presenter?.sendResultClicked()
        }

        btn_get_result.setOnClickListener {
            presenter?.getFullResultClicked()
        }

        ib_reset_vp.setOnClickListener {
            showResetDialog()
        }

        presenter?.onViewCreated()
    }

    override fun onStop() {
        presenter?.saveData()
        super.onStop()
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun showFullResultDialog(result: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Результат игры")
        builder.setMessage(result)
        builder.create().show()
    }

    override fun showSendResultDialog(myName: String, result: String) {
        val dialog: AlertDialog = createSendResultDialog(myName, result)
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            when {
                myNameEt.text.toString() == "" -> ViewCompat.setBackgroundTintList(myNameEt, ColorStateList.valueOf(ContextCompat.getColor(this@MissionMeterActivity,R.color.warning_red)))
                oppNameEt.text.toString() == "" -> ViewCompat.setBackgroundTintList(oppNameEt, ColorStateList.valueOf(ContextCompat.getColor(this@MissionMeterActivity,R.color.warning_red)))
                else -> {
                    GamePoints.myName = myNameEt.text.toString()
                    GamePoints.oppName = oppNameEt.text.toString()
                    dialog.dismiss()
                    presenter?.routResultOut(GamePoints.generateShortResult())
                }
            }
        }
    }

    override fun createSendResultDialog(myName: String, result: String): AlertDialog {
        val inflater = LayoutInflater.from(this).inflate(R.layout.share_game_result_dialog, null)
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Поделиться результатами")
        builder.setView(inflater)

        myNameEt = inflater.findViewById(R.id.et_my_name)
        myNameEt.addTextChangedListener(getNameCorrectTextWatcher(myNameEt))
        myNameEt.setText(myName)

        oppNameEt = inflater.findViewById(R.id.et_opp_name)
        oppNameEt.addTextChangedListener(getNameCorrectTextWatcher(oppNameEt))

        builder
                .setPositiveButton("Отправить") { _, _ -> }
                .setNegativeButton("Отмена") { _, _ -> }
        val dialog: AlertDialog = builder.create()
        return dialog
    }

    override fun showResetDialog() {
        val builder = AlertDialog.Builder(this@MissionMeterActivity)
        builder.setTitle("Сбросить значения?")

        builder.setPositiveButton("Да") { _, _ ->
            presenter?.resetClicked()
        }

        builder.setNegativeButton("Нет") {dialog, which ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    override fun setDataToView(etData: ArrayList<TurnVp>, secMissionsStatus: ArrayList<SecondaryMissionVp>) {
        val viewAdapter = SecondaryMissionsAdapter()
        val myLayoutManager = LinearLayoutManager(this)

        viewAdapter.setData(secMissionsStatus)
        viewAdapter.addItems(etData)

        recyclerView = findViewById<RecyclerView>(R.id.rv_mission_meter).apply {
            setHasFixedSize(true)
            layoutManager = myLayoutManager
            adapter = viewAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun getNameCorrectTextWatcher(elem: EditText): TextWatcher {
        return object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                ViewCompat.setBackgroundTintList(elem, ColorStateList.valueOf(ContextCompat.getColor(this@MissionMeterActivity, R.color.colorAccent)))
            }
        }
    }
}

package com.test.kolesnikovvv.myapplication.view.activities

import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.GamePoints
import com.test.kolesnikovvv.myapplication.textWatchers.MissionMeterEtTw
import kotlinx.android.synthetic.main.activity_mission_meter.*
import kotlinx.android.synthetic.main.content_mission_meter.*
import android.content.res.ColorStateList
import android.support.v4.view.ViewCompat
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.EditText
import com.test.kolesnikovvv.myapplication.MissionMeterContract
import com.test.kolesnikovvv.myapplication.presenter.MissionMeterPresenter


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

        setListenersToEt()
        setListenersToCB()

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
        val inflater = LayoutInflater.from(this).inflate(R.layout.share_game_result_dialog, null)
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Поделиться результатами")
        builder.setView(inflater)

        val myNameEt = inflater.findViewById<EditText>(R.id.et_my_name)
        myNameEt.addTextChangedListener(getNameCorrectTextWatcher(myNameEt))
        myNameEt.setText(myName)

        val oppNameEt = inflater.findViewById<EditText>(R.id.et_opp_name)
        oppNameEt.addTextChangedListener(getNameCorrectTextWatcher(oppNameEt))

        builder
                .setPositiveButton("Отправить") { _, _ -> }
                .setNegativeButton("Отмена") { _, _ -> }
        val dialog: AlertDialog = builder.create()
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            when {
                myNameEt.text.toString() == "" -> ViewCompat.setBackgroundTintList(myNameEt, ColorStateList.valueOf(getColor(R.color.warning_red)))
                oppNameEt.text.toString() == "" -> ViewCompat.setBackgroundTintList(oppNameEt, ColorStateList.valueOf(getColor(R.color.warning_red)))
                else -> {
                    GamePoints.myName = myNameEt.text.toString()
                    GamePoints.oppName = oppNameEt.text.toString()
                    dialog.dismiss()

                    presenter?.routResultOut(GamePoints.generateShortResult())
                }
            }
        }
    }

    override fun showResetDialog() {
        val builder = AlertDialog.Builder(this@MissionMeterActivity)
        builder.setTitle("Сбросить значения?")

        builder.setPositiveButton("Да") { _, _ ->
            presenter?.resetClicked()
        }

        builder.setNegativeButton("Нет") { _, _ -> }

        builder.create().show()
    }

    override fun setDataToView(myPoints: Array<String>, oppPoints: Array<String>, cbStatus: Array<Boolean>) {
        et_turn_one_my_vp.setText(myPoints[0])
        et_turn_two_my_vp.setText(myPoints[1])
        et_turn_three_my_vp.setText(myPoints[2])
        et_turn_four_my_vp.setText(myPoints[3])
        et_turn_five_my_vp.setText(myPoints[4])
        et_turn_six_my_vp.setText(myPoints[5])
        et_turn_seven_my_vp.setText(myPoints[6])

        et_turn_one_opp_vp.setText(oppPoints[0])
        et_turn_two_opp_vp.setText(oppPoints[1])
        et_turn_three_opp_vp.setText(oppPoints[2])
        et_turn_four_opp_vp.setText(oppPoints[3])
        et_turn_five_opp_vp.setText(oppPoints[4])
        et_turn_six_opp_vp.setText(oppPoints[5])
        et_turn_seven_opp_vp.setText(oppPoints[6])

        cb_my_fb.isChecked = cbStatus[0]
        cb_opp_fb.isChecked = cbStatus[1]
        cb_my_wk.isChecked = cbStatus[2]
        cb_opp_wk.isChecked = cbStatus[3]
        cb_my_bl.isChecked = cbStatus[4]
        cb_opp_bl.isChecked = cbStatus[5]
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setListenersToEt() {
        et_turn_one_my_vp.addTextChangedListener(MissionMeterEtTw(true,0))
        et_turn_one_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 0))
        et_turn_two_my_vp.addTextChangedListener(MissionMeterEtTw(true, 1))
        et_turn_two_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 1))
        et_turn_three_my_vp.addTextChangedListener(MissionMeterEtTw(true, 2))
        et_turn_three_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 2))
        et_turn_four_my_vp.addTextChangedListener(MissionMeterEtTw(true,3))
        et_turn_four_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 3))
        et_turn_five_my_vp.addTextChangedListener(MissionMeterEtTw(true,4))
        et_turn_five_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 4))
        et_turn_six_my_vp.addTextChangedListener(MissionMeterEtTw(true,5))
        et_turn_six_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 5))
        et_turn_seven_my_vp.addTextChangedListener(MissionMeterEtTw(true,6))
        et_turn_seven_opp_vp.addTextChangedListener(MissionMeterEtTw(false, 6))
    }

    private fun setListenersToCB() {
        cb_my_fb.setOnClickListener {
            if (cb_my_fb.isChecked)
                GamePoints.myFb = 1
            else
                GamePoints.myFb = 0
        }

        cb_opp_fb.setOnClickListener {
            if (cb_opp_fb.isChecked)
                GamePoints.oppFb = 1
            else
                GamePoints.oppFb = 0
        }

        cb_my_wk.setOnClickListener {
            if (cb_my_wk.isChecked)
                GamePoints.myWk = 1
            else
                GamePoints.myWk = 0
        }

        cb_opp_wk.setOnClickListener {
            if (cb_opp_wk.isChecked)
                GamePoints.oppWk = 1
            else
                GamePoints.oppWk = 0
        }

        cb_my_bl.setOnClickListener {
            if (cb_my_bl.isChecked)
                GamePoints.myBl = 1
            else
                GamePoints.myBl = 0
        }

        cb_opp_bl.setOnClickListener {
            if (cb_opp_bl.isChecked)
                GamePoints.oppBl = 1
            else
                GamePoints.oppBl = 0
        }

//        cb_opp_fb.setOnClickListener {
//            val sharedPref = getPreferences(Context.MODE_PRIVATE)
//            with(sharedPref.edit()) {
//                if (cb_my_fb.isChecked)
//                    putInt("oppFb", 1)
//                else
//                    putInt("oppFb", 0)
//                apply()
//            }
//        }
//
//        cb_my_wk.setOnClickListener {
//            val sharedPref = getPreferences(Context.MODE_PRIVATE)
//            with(sharedPref.edit()) {
//                if (cb_my_fb.isChecked)
//                    putInt("myWk", 1)
//                else
//                    putInt("myWk", 0)
//                apply()
//            }
//        }
//
//        cb_opp_wk.setOnClickListener {
//            val sharedPref = getPreferences(Context.MODE_PRIVATE)
//            with(sharedPref.edit()) {
//                if (cb_my_fb.isChecked)
//                    putInt("oppWk", 1)
//                else
//                    putInt("oppWk", 0)
//                apply()
//            }
//        }
//
//        cb_my_bl.setOnClickListener {
//            val sharedPref = getPreferences(Context.MODE_PRIVATE)
//            with(sharedPref.edit()) {
//                if (cb_my_fb.isChecked)
//                    putInt("myBl", 1)
//                else
//                    putInt("myBl", 0)
//                apply()
//            }
//        }
//
//        cb_opp_bl.setOnClickListener {
//            val sharedPref = getPreferences(Context.MODE_PRIVATE)
//            with(sharedPref.edit()) {
//                if (cb_my_fb.isChecked)
//                    putInt("oppBl", 1)
//                else
//                    putInt("oppBl", 0)
//                apply()
//            }
//        }
    }

    private fun getNameCorrectTextWatcher(elem: EditText): TextWatcher {
        return object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                ViewCompat.setBackgroundTintList(elem, ColorStateList.valueOf(getColor(R.color.colorAccent)))
            }
        }
    }
}

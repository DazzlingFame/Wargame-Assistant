package com.test.kolesnikovvv.myapplication.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.objects.GamePoints
import com.test.kolesnikovvv.myapplication.textWatchers.MissionMeterEtTw
import kotlinx.android.synthetic.main.activity_mission_meter.*
import kotlinx.android.synthetic.main.content_mission_meter.*
import android.widget.Toast
import android.content.Intent
import android.content.res.ColorStateList
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText


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
class MissionMeterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_meter)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = getColor(R.color.colorPrimaryDark)

        fab.setOnClickListener {
            val linf = LayoutInflater.from(this)
            val inflator = linf.inflate(R.layout.share_game_result_dialog, null)
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Поделиться результатами")
            builder.setView(inflator)
            val myNameEt = inflator.findViewById<EditText>(R.id.et_my_name)
            if (GamePoints.myName != "вас")
                myNameEt.setText(GamePoints.myName)
            val oppNameEt = inflator.findViewById<EditText>(R.id.et_opp_name)
                    builder
                    .setPositiveButton("Отправить") { dialog, id ->
//                        if (myNameEt.text.toString() == "") {
//                            ViewCompat.setBackgroundTintList(myNameEt, ColorStateList.valueOf(getColor(R.color.warning_red)))
//                        }
//                        if (myNameEt.text.toString() != "вас")
//                            GamePoints.myName = myNameEt.text.toString()
//                        if (oppNameEt.text.toString() != "оппонента")
//                            GamePoints.oppName = oppNameEt.text.toString()
//
//                        val sendIntent = Intent()
//                        sendIntent.action = Intent.ACTION_SEND
//                        sendIntent
//                                .putExtra(Intent.EXTRA_TEXT,
//                                        GamePoints.generateShortResult())
//                        sendIntent.type = "text/plain"
//                        try {
//                            startActivity(sendIntent)
//                        } catch (ex: android.content.ActivityNotFoundException) {
//                            Toast.makeText(applicationContext, "Please Install VK", Toast.LENGTH_SHORT).show()
//                        }
                    }
                    .setNegativeButton("Отмена") { dialog, which -> }
            val dialog: AlertDialog = builder.create()
            dialog.show()
            val btnPositive: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            btnPositive.setOnClickListener {
                if (myNameEt.text.toString() == "") {
                    ViewCompat.setBackgroundTintList(myNameEt, ColorStateList.valueOf(getColor(R.color.warning_red)))
                } else {
                    if (myNameEt.text.toString() != "вас")
                        GamePoints.myName = myNameEt.text.toString()
                    if (oppNameEt.text.toString() != "оппонента")
                        GamePoints.oppName = oppNameEt.text.toString()

                    val sendIntent = Intent()
                    sendIntent.action = Intent.ACTION_SEND
                    sendIntent
                            .putExtra(Intent.EXTRA_TEXT,
                                    GamePoints.generateShortResult())
                    sendIntent.type = "text/plain"
                    try {
                        startActivity(sendIntent)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(applicationContext, "Please Install VK", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        btn_get_result.setOnClickListener { 
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Результат игры")
            builder.setMessage(GamePoints.generateResult())
            builder.setPositiveButton("Ok") { dialog, which ->  }
            builder.create().show()
        }
        ib_reset_vp.setOnClickListener {
            val builder = AlertDialog.Builder(this@MissionMeterActivity)
            builder.setTitle("Сбросить значения?")

            builder.setPositiveButton("Да") { dialog, which ->
                GamePoints.reset()
                setDataToEtFromClass()                                                //Обновление значений в UI
                setDataToCbFromClass()
            }

            builder.setNegativeButton("Нет") { dialog, which ->
            }

            builder.create().show()
        }

        setListenersToEt()
        setListenersToCB()

        getPreferencesToClass()

        setDataToEtFromClass()
        setDataToCbFromClass()
    }

    override fun onStop() {
        super.onStop()
        updatePreferencesFromClass()
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

    private fun setDataToCbFromClass() {
        cb_my_fb.isChecked = GamePoints.myFb == 1
        cb_opp_fb.isChecked = GamePoints.oppFb == 1
        cb_my_wk.isChecked = GamePoints.myWk == 1
        cb_opp_wk.isChecked = GamePoints.oppWk == 1
        cb_my_bl.isChecked = GamePoints.myBl == 1
        cb_opp_bl.isChecked = GamePoints.oppBl == 1
    }

    private fun setDataToEtFromClass() {
        et_turn_one_my_vp.setText(GamePoints.myTurnVp[0])
        et_turn_one_opp_vp.setText(GamePoints.oppTurnVp[0])
        et_turn_two_my_vp.setText(GamePoints.myTurnVp[1])
        et_turn_two_opp_vp.setText(GamePoints.oppTurnVp[1])
        et_turn_three_my_vp.setText(GamePoints.myTurnVp[2])
        et_turn_three_opp_vp.setText(GamePoints.oppTurnVp[2])
        et_turn_four_my_vp.setText(GamePoints.myTurnVp[3])
        et_turn_four_opp_vp.setText(GamePoints.oppTurnVp[3])
        et_turn_five_my_vp.setText(GamePoints.myTurnVp[4])
        et_turn_five_opp_vp.setText(GamePoints.oppTurnVp[4])
        et_turn_six_my_vp.setText(GamePoints.myTurnVp[5])
        et_turn_six_opp_vp.setText(GamePoints.oppTurnVp[5])
        et_turn_seven_my_vp.setText(GamePoints.myTurnVp[6])
        et_turn_seven_opp_vp.setText(GamePoints.oppTurnVp[6])
    }

    private fun getPreferencesToClass() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val savedEtVp = sharedPref.getString("gameData", ",,,,,,,;,,,,,,,")

        GamePoints.parseFromStringToClass(savedEtVp)
        GamePoints.myFb = sharedPref.getInt("myFb", 0)
        GamePoints.oppFb = sharedPref.getInt("oppFb", 0)
        GamePoints.myWk = sharedPref.getInt("myWk", 0)
        GamePoints.oppWk = sharedPref.getInt("oppWk", 0)
        GamePoints.myBl = sharedPref.getInt("myBl", 0)
        GamePoints.oppBl = sharedPref.getInt("oppBl", 0)
        GamePoints.myName = sharedPref.getString("myName", "вас")
    }

    private fun updatePreferencesFromClass() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("gameData", GamePoints.parseEtResultFromClassToString())
            putInt("myFb", GamePoints.myFb)
            putInt("oppFb", GamePoints.oppFb)
            putInt("myWk", GamePoints.myWk)
            putInt("oppWk", GamePoints.oppWk)
            putInt("myBl", GamePoints.myBl)
            putInt("oppBl", GamePoints.oppBl)
            putString("myName", GamePoints.myName)
            apply()
        }
    }
}

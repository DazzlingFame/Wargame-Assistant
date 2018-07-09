package com.test.kolesnikovvv.myapplication.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.test.kolesnikovvv.myapplication.MissionMeterContract
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.GamePoints
import com.test.kolesnikovvv.myapplication.entity.SecondaryMissionVp
import com.test.kolesnikovvv.myapplication.interactor.MissionMeterInteractor

class MissionMeterPresenter(private var view: MissionMeterContract.View?, private var context: Context): MissionMeterContract.Presenter {

    private var gp = GamePoints()
    public fun setGp(value: GamePoints) {
        gp = value
    }

    private var interactor: MissionMeterContract.Interactor? = MissionMeterInteractor()
    private var missionNamesArray = arrayListOf<String>(
            context.getString(R.string.first_blood_name),
            context.getString(R.string.warlord_kill_name),
            context.getString(R.string.behind_enemy_lines_name)
    )

    override fun onViewCreated() {
        interactor?.updateClassFromPreferences(context)

        val turnVpArrayList = gp.parseToTurnVpArrayList()
        val secMissionArrayList = gp.parseToSecMissionsArrayList(missionNamesArray)

        view?.setDataToView(turnVpArrayList, secMissionArrayList)
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }

    override fun saveData() {
        interactor?.updatePreferencesFromClass(context)
    }

    override fun resetClicked() {
        gp.reset()
        view?.setDataToView(gp.parseToTurnVpArrayList(), gp.parseToSecMissionsArrayList(missionNamesArray))
    }

    override fun getFullResultClicked() {
        view?.showFullResultDialog(gp.generateFullResult())
    }

    override fun sendResultClicked() {
        view?.showSendResultDialog(gp.myName, gp.generateShortResult())
    }

    override fun secMissionCbClicked(item: SecondaryMissionVp) {
        if (item.my) {
            if (gp.mySecVp[item.missionIndex] == 1) {
                gp.mySecVp[item.missionIndex] = 0
            }
            else
                gp.mySecVp[item.missionIndex] = 1
            }
        else {
            if (gp.oppSecVp[item.missionIndex] == 1) {
                gp.oppSecVp[item.missionIndex] = 0
            }
            else
                gp.oppSecVp[item.missionIndex] = 1
        }
    }

    override fun routResultOut(text: String) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, text)
        sendIntent.type = "text/plain"
        try {
            startActivity(context, sendIntent, Bundle.EMPTY)
        } catch (ex: android.content.ActivityNotFoundException) {
            Toast.makeText(context, "Please Install VK", Toast.LENGTH_SHORT).show()
        }
    }


}
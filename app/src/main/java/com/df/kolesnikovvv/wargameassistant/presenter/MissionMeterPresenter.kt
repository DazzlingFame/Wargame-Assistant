package com.df.kolesnikovvv.wargameassistant.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.df.kolesnikovvv.wargameassistant.MissionMeterContract
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.entity.GamePoints
import com.df.kolesnikovvv.wargameassistant.entity.SecondaryMissionVp
import com.df.kolesnikovvv.wargameassistant.interactor.MissionMeterInteractor

class MissionMeterPresenter(private var view: MissionMeterContract.View?, private var context: Context): MissionMeterContract.Presenter {

    private var interactor: MissionMeterContract.Interactor? = MissionMeterInteractor()
    private var missionNamesArray = arrayListOf<String>(
            context.getString(R.string.first_blood_name),
            context.getString(R.string.warlord_kill_name),
            context.getString(R.string.behind_enemy_lines_name)
    )

    override fun onViewCreated() {
        interactor?.updateClassFromPreferences(context)

        val turnVpArrayList = GamePoints.gameVp
        val secMissionArrayList = GamePoints.parseToSecMissionsArrayList(missionNamesArray)

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
        GamePoints.reset()
        view?.setDataToView(GamePoints.gameVp, GamePoints.parseToSecMissionsArrayList(missionNamesArray))
    }

    override fun getFullResultClicked() {
        view?.showFullResultDialog(GamePoints.generateFullResult())
    }

    override fun sendResultClicked() {
        view?.showSendResultDialog(GamePoints.myName, GamePoints.generateShortResult())
    }

    override fun secMissionCbClicked(item: SecondaryMissionVp) {
        if (item.my) {
            if (GamePoints.mySecVp[item.missionIndex] == 1) {
                GamePoints.mySecVp[item.missionIndex] = 0
            }
            else
                GamePoints.mySecVp[item.missionIndex] = 1
            }
        else {
            if (GamePoints.oppSecVp[item.missionIndex] == 1) {
                GamePoints.oppSecVp[item.missionIndex] = 0
            }
            else
                GamePoints.oppSecVp[item.missionIndex] = 1
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
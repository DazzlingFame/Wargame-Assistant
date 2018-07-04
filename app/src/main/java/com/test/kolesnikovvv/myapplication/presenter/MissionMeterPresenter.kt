package com.test.kolesnikovvv.myapplication.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.test.kolesnikovvv.myapplication.MissionMeterContract
import com.test.kolesnikovvv.myapplication.entity.GamePoints
import com.test.kolesnikovvv.myapplication.interactor.MissionMeterInteractor

class MissionMeterPresenter(private var view: MissionMeterContract.View?, private var context: Context): MissionMeterContract.Presenter {

    private var interactor: MissionMeterContract.Interactor? = MissionMeterInteractor()

    override fun onViewCreated() {
        interactor?.updateClassFromPreferences(context)
        view?.setDataToView(GamePoints.myTurnVp, GamePoints.oppTurnVp, GamePoints.getCbArray())
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
        view?.setDataToView(GamePoints.myTurnVp, GamePoints.oppTurnVp, GamePoints.getCbArray())
    }

    override fun getFullResultClicked() {
        view?.showFullResultDialog(GamePoints.generateFullResult())
    }

    override fun sendResultClicked() {
        view?.showSendResultDialog(GamePoints.myName, GamePoints.generateShortResult())
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
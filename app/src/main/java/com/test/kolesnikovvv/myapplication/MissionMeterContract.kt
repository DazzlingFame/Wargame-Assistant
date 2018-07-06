package com.test.kolesnikovvv.myapplication

import android.content.Context
import android.support.v7.app.AlertDialog
import com.test.kolesnikovvv.myapplication.entity.SecondaryMissionVp
import com.test.kolesnikovvv.myapplication.entity.TurnVp

interface MissionMeterContract {
    interface View {
        fun showFullResultDialog(result: String)
        fun showSendResultDialog(myName: String, result: String)
        fun showResetDialog()
        fun createSendResultDialog(myName: String, result: String): AlertDialog
        fun setDataToView(etData: ArrayList<TurnVp>, secMissionsStatus: ArrayList<SecondaryMissionVp>)
    }

    interface Presenter {
        //User actions
        fun secMissionCbClicked(item: SecondaryMissionVp)
        fun resetClicked()
        fun getFullResultClicked()
        fun sendResultClicked()
        fun routResultOut(text: String)

        //Model updates
        fun onViewCreated()
        fun onDestroy()
        fun saveData()
    }

    interface Interactor {
        fun updateClassFromPreferences(context: Context)
        fun updatePreferencesFromClass(context: Context)
    }
}
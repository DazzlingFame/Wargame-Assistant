package com.test.kolesnikovvv.myapplication

import android.content.Context

interface MissionMeterContract {
    interface View {
        fun showFullResultDialog(result: String)
        fun showSendResultDialog(myName: String, result: String)
        fun showResetDialog()
        fun setDataToView(myPoints: Array<String>, oppPoints: Array<String>, cbStatus: Array<Boolean>)
    }

    interface Presenter {
        //User actions
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
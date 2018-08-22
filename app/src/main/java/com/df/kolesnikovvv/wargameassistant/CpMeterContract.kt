package com.df.kolesnikovvv.wargameassistant

import android.content.Context

interface CpMeterContract {
    interface View {
        fun setDataToView(myCp: Int, oppCp: Int)
    }

    interface Presenter {
        //User actions
        fun changeCpClicked(my: Boolean, plus: Boolean)

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
package com.df.kolesnikovvv.wargameassistant

import android.content.Context
import android.view.MenuItem

interface DrawerContract {
    
    interface Presenter {
        //User actions
        fun navigationItemSelected(item: MenuItem, context: Context)
    }

    interface Interactor {
        fun saveLastFaction(context: Context, factionName: String)
    }

    interface Router {
        fun navigateToMissionMeter(context: Context)
        fun navigateToMain(context: Context)
    }
}
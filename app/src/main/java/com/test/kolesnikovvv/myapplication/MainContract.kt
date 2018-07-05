package com.test.kolesnikovvv.myapplication

import android.content.Context
import android.view.MenuItem
import com.test.kolesnikovvv.myapplication.entity.Unit


interface MainContract {
    interface View {
        fun publishDataList(data: ArrayList<Unit>)
        fun closeDrawer()
    }

    interface Presenter {
        //User actions
        fun listItemClicked(item: Unit)
        fun navigationItemSelected(item: MenuItem)

        //Model updates
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor {
        fun getLastFaction(context: Context): Unit.Factions
        fun saveLastFaction(context: Context, factionName: String)
        fun getUnitList(factionName: Unit.Factions): ArrayList<Unit>
    }

    interface Router {
        fun navigateToBigCard(item: Unit, context: Context)
        fun navigateToMissionMeter(context: Context)
    }
}
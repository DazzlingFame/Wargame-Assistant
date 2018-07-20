package com.df.kolesnikovvv.wargameassistant

import android.content.Context
import android.view.MenuItem
import com.df.kolesnikovvv.wargameassistant.entity.Unit


interface MainContract {
    interface View {
        fun publishDataList(data: ArrayList<Unit>)
        fun closeDrawer()
    }

    interface Presenter {
        //User actions
        fun listItemClicked(item: Unit)
        fun navigationItemSelected(item: MenuItem)
        fun searchTextChanged(text: String)

        //Model updates
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor {
        fun getLastFaction(context: Context): Unit.Factions
        fun saveLastFaction(context: Context, factionName: String)
        fun getUnitList(factionName: Unit.Factions): ArrayList<Unit>
        fun getSearchedUnitList(factionName: Unit.Factions, searchText: String): ArrayList<Unit>
    }

    interface Router {
        fun navigateToBigCard(item: Unit, context: Context)
        fun navigateToMissionMeter(context: Context)
    }
}
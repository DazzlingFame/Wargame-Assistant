package com.df.kolesnikovvv.wargameassistant

import android.content.Context
import com.df.kolesnikovvv.wargameassistant.entity.Unit

interface MainContract {
    interface View {
        fun publishDataList(data: ArrayList<Unit>)
    }

    interface Presenter {
        //User actions
        fun listItemClicked(item: Unit)
        fun searchTextChanged(text: String)

        //Model updates
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor {
        fun getLastFaction(context: Context): Unit.Factions
        fun getUnitList(factionName: Unit.Factions): ArrayList<Unit>
        fun getSearchedUnitList(factionName: Unit.Factions, searchText: String): ArrayList<Unit>
    }

    interface Router {
        fun navigateToBigCard(item: Unit, context: Context)
    }
}
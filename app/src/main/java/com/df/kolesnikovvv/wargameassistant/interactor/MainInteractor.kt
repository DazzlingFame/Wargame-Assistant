package com.df.kolesnikovvv.wargameassistant.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.df.kolesnikovvv.wargameassistant.MainContract
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.entity.Unit
import com.df.kolesnikovvv.wargameassistant.entity.UnitData

class MainInteractor: MainContract.Interactor {

    override fun getUnitList(factionName: Unit.Factions): ArrayList<Unit> {
        return when(factionName) {
            Unit.Factions.Necrons -> UnitData().necrons
            Unit.Factions.Mechanicus -> UnitData().admechs
        }
    }

    override fun getSearchedUnitList(factionName: Unit.Factions, searchText: String): ArrayList<Unit> {
        val faction = when(factionName) {
            Unit.Factions.Necrons -> UnitData().necrons
            Unit.Factions.Mechanicus -> UnitData().admechs
        }

        val searchResult: ArrayList<Unit> = arrayListOf()

        for (unit in faction) {
            if (unit.name.toLowerCase().contains(searchText.toLowerCase())) {
                searchResult.add(unit)
            }
        }
        return searchResult
    }

    override fun getLastFaction(context: Context): Unit.Factions {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val lastFaction = sharedPref.getString(context.getString(R.string.last_faction_key), context.getString(R.string.necrons_name))

        when(lastFaction) {
            context.getString(R.string.necrons_name) -> return Unit.Factions.Necrons
            context.getString(R.string.admechs_name) -> return Unit.Factions.Mechanicus
        }
        return Unit.Factions.Necrons
    }
}
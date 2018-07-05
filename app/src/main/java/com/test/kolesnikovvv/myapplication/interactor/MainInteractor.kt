package com.test.kolesnikovvv.myapplication.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.test.kolesnikovvv.myapplication.MainContract
import com.test.kolesnikovvv.myapplication.entity.Unit
import com.test.kolesnikovvv.myapplication.entity.UnitData

class MainInteractor: MainContract.Interactor {

    override fun getUnitList(factionName: Unit.Factions): ArrayList<Unit> {
        return when(factionName) {
            Unit.Factions.Necrons -> UnitData().necrons
            Unit.Factions.Mechanicus -> UnitData().admechs
        }
    }

    override fun getLastFaction(context: Context): Unit.Factions {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val lastFaction = sharedPref.getString("lastFaction", "necrons")

        when(lastFaction) {
            "necrons" -> return Unit.Factions.Necrons
            "mechanicus" -> return Unit.Factions.Mechanicus
        }
        return Unit.Factions.Necrons
    }

    override fun saveLastFaction(context: Context, factionName: String) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        with(sharedPref.edit()) {
            putString("lastFaction", factionName)
            apply()
        }
    }

}
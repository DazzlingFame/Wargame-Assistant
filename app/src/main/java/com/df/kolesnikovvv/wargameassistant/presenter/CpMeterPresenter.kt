package com.df.kolesnikovvv.wargameassistant.presenter

import android.content.Context
import com.df.kolesnikovvv.wargameassistant.CpMeterContract
import com.df.kolesnikovvv.wargameassistant.entity.CommandPoints
import com.df.kolesnikovvv.wargameassistant.interactor.CpMeterInteractor

class CpMeterPresenter(private var view: CpMeterContract.View?, private val context: Context) : CpMeterContract.Presenter {
    val interactor: CpMeterContract.Interactor = CpMeterInteractor()

    override fun changeCpClicked(my: Boolean, plus: Boolean) {
        if (my) {
            if (plus) {
                CommandPoints.myCp++
            } else {
                CommandPoints.myCp--
            }
        } else {
            if (plus) {
                CommandPoints.oppCp++
            } else {
                CommandPoints.oppCp--
            }
        }
        view?.setDataToView(CommandPoints.myCp, CommandPoints.oppCp)
    }

    override fun onViewCreated() {
        interactor.updateClassFromPreferences(context)
        view?.setDataToView(CommandPoints.myCp, CommandPoints.oppCp)
    }

    override fun onDestroy() {
        saveData()
    }

    override fun saveData() {
        interactor.updatePreferencesFromClass(context)
    }

    override fun resetClicked() {
        CommandPoints.reset()
        view?.setDataToView(CommandPoints.myCp, CommandPoints.oppCp)
    }
}
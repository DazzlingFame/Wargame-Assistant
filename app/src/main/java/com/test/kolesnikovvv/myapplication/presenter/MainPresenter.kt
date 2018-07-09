package com.test.kolesnikovvv.myapplication.presenter

import android.content.Context
import android.view.MenuItem
import com.test.kolesnikovvv.myapplication.MainContract
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.Unit
import com.test.kolesnikovvv.myapplication.interactor.MainInteractor
import com.test.kolesnikovvv.myapplication.router.MainRouter

class MainPresenter(private var view: MainContract.View?, private val context: Context): MainContract.Presenter {

    private var interactor: MainContract.Interactor? = MainInteractor()
    private var router: MainContract.Router? = MainRouter()

    override fun listItemClicked(item: Unit) {
        router?.navigateToBigCard(item, context)
    }

    override fun navigationItemSelected(item: MenuItem) {
        when (item.itemId) {
            R.id.nav_necrons -> {
                interactor?.saveLastFaction(context, context.getString(R.string.necrons_name))
                view?.publishDataList(interactor!!.getUnitList(Unit.Factions.Necrons))
            }
            R.id.nav_admechs -> {
                interactor?.saveLastFaction(context, context.getString(R.string.admechs_name))
                view?.publishDataList(interactor!!.getUnitList(Unit.Factions.Mechanicus))
            }
            R.id.nav_vp_tracker -> {
                router?.navigateToMissionMeter(context)
            }
        }

        view?.closeDrawer()
    }

    override fun onViewCreated() {
        view?.publishDataList(interactor!!.getUnitList(interactor!!.getLastFaction(context)))
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }
}
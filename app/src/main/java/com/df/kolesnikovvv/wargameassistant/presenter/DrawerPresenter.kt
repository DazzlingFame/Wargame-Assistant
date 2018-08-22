package com.df.kolesnikovvv.wargameassistant.presenter

import android.content.Context
import android.view.MenuItem
import com.df.kolesnikovvv.wargameassistant.DrawerContract
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.interactor.DrawerInteractor
import com.df.kolesnikovvv.wargameassistant.router.DrawerRouter

class DrawerPresenter(context: Context) : DrawerContract.Presenter {
    private val interactor: DrawerContract.Interactor = DrawerInteractor(context)
    private val router: DrawerContract.Router = DrawerRouter(context)

    override fun navigationItemSelected(item: MenuItem, context: Context) {
        when (item.itemId) {
            R.id.nav_necrons -> {
                interactor.saveLastFaction(context, context.getString(R.string.necrons_name))
                router.navigateToMain(context)
            }
            R.id.nav_admechs -> {
                interactor.saveLastFaction(context, context.getString(R.string.admechs_name))
                router.navigateToMain(context)
            }
            R.id.nav_vp_tracker -> {
                router.navigateToMissionMeter(context)
            }
            R.id.nav_cp_tracker -> {
                router.navigateToCpMeter(context)
            }
            else -> {
                router.navigateToMain(context)
            }
        }
    }
}
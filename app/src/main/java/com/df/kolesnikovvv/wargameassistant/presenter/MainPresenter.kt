package com.df.kolesnikovvv.wargameassistant.presenter

import android.content.Context
import com.df.kolesnikovvv.wargameassistant.MainContract
import com.df.kolesnikovvv.wargameassistant.entity.Unit
import com.df.kolesnikovvv.wargameassistant.interactor.MainInteractor
import com.df.kolesnikovvv.wargameassistant.router.MainRouter

class MainPresenter(private var view: MainContract.View?, private val context: Context): MainContract.Presenter {
    private var interactor: MainContract.Interactor? = MainInteractor()
    private var router: MainContract.Router? = MainRouter()

    override fun listItemClicked(item: Unit) {
        router?.navigateToBigCard(item, context)
    }

    override fun searchTextChanged(text: String) {
        view?.publishDataList(interactor!!.getSearchedUnitList(interactor!!.getLastFaction(context), text))
    }

    override fun searchResetClicked() {
        view?.resetSearchText()
        view?.publishDataList(interactor!!.getUnitList(interactor!!.getLastFaction(context)))
    }

    override fun onViewCreated() {
        view?.publishDataList(interactor!!.getUnitList(interactor!!.getLastFaction(context)))
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }
}
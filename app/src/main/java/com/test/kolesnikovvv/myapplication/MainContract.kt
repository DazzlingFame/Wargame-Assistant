package com.test.kolesnikovvv.myapplication

import com.test.kolesnikovvv.myapplication.entity.Unit


interface MainContract {
    interface View {
        fun publishDataList(data: ArrayList<Unit>)
    }

    interface Presenter {
        //User actions
        fun listItemClicked(item: Unit)

        //Model updates
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor {
        fun getUnitList(factionName: String): ArrayList<Unit>
    }
}
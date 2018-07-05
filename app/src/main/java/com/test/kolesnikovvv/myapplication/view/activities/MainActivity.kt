package com.test.kolesnikovvv.myapplication.view.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.test.kolesnikovvv.myapplication.MainContract
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.view.adapters.MainListingAdapter
import com.test.kolesnikovvv.myapplication.entity.Unit
import com.test.kolesnikovvv.myapplication.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseDrawerActivity(), MainContract.View, NavigationView.OnNavigationItemSelectedListener {

    override fun getToolbarInstance(): Toolbar? = toolbar

    private var presenter: MainContract.Presenter? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getToolbarInstance()

        presenter = MainPresenter(this, this)

        nav_view.setNavigationItemSelectedListener(this)

        presenter?.onViewCreated()
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun publishDataList(data: ArrayList<Unit>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = MainListingAdapter(data) { unitItem: Unit -> presenter?.listItemClicked(unitItem) }

        recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        presenter?.navigationItemSelected(item)
        return true
    }

    override fun closeDrawer() {
        drawer_layout.closeDrawer(GravityCompat.START)
    }
}

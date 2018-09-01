package com.df.kolesnikovvv.wargameassistant.view.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import com.df.kolesnikovvv.wargameassistant.DrawerContract
import com.df.kolesnikovvv.wargameassistant.MainContract
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.entity.Unit
import com.df.kolesnikovvv.wargameassistant.presenter.DrawerPresenter
import com.df.kolesnikovvv.wargameassistant.presenter.MainPresenter
import com.df.kolesnikovvv.wargameassistant.view.adapters.MainListingAdapter


class MainActivity : BaseDrawerActivity(), MainContract.View, NavigationView.OnNavigationItemSelectedListener {
    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar)}
    override fun getToolbarInstance(): Toolbar? = toolbar

    private var presenter: MainContract.Presenter? = null
    private var drawerPresenter: DrawerContract.Presenter? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var etSearch: EditText
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getToolbarInstance()

        etSearch = findViewById(R.id.et_search)
        etSearch.addTextChangedListener(searchTextWatcher())

        presenter = MainPresenter(this, this)
        drawerPresenter = DrawerPresenter(this)

        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener(this)

        drawerLayout = findViewById(R.id.drawer_layout)

        val btnResetSearch = findViewById<ImageButton>(R.id.ib_reset_search)
        btnResetSearch.setOnClickListener {
            presenter?.searchResetClicked()
            closeKeyboard()
        }

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

    override fun resetSearchText() {
        etSearch.setText("")
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        drawerPresenter?.navigationItemSelected(item, this)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun searchTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                presenter?.searchTextChanged(s.toString())
            }
        }
    }

}

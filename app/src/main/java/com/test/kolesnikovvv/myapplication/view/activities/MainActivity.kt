package com.test.kolesnikovvv.myapplication.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.view.adapters.MainListingAdapter
import com.test.kolesnikovvv.myapplication.entity.Unit
import com.test.kolesnikovvv.myapplication.entity.UnitData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val items: ArrayList<Unit> = UnitData().necrons

        viewManager = LinearLayoutManager(this)
        viewAdapter = MainListingAdapter(items, { unitItem: Unit -> unitItemClicked(unitItem) })

        recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun unitItemClicked(unitItem: Unit) {
        val intent = Intent(this, BigCardActivity::class.java)
        intent.putExtra("name", unitItem.name)
        intent.putExtra("stats", unitItem.stats)
        intent.putExtra("image", unitItem.image.toString())
        intent.putExtra("weapons", unitItem.weapons)
        intent.putExtra("bigData", unitItem.bigData)
        startActivity(intent)
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
        when (item.itemId) {
            R.id.nav_necrons -> {
                viewAdapter = MainListingAdapter(UnitData().necrons, { unitItem: Unit -> unitItemClicked(unitItem) })

                recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }

            }
            R.id.nav_admechs -> {
                viewAdapter = MainListingAdapter(UnitData().adeptusMechanicus, { unitItem: Unit -> unitItemClicked(unitItem) })

                recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }
            R.id.nav_vp_tracker -> {
                val intent = Intent(this, MissionMeterActivity::class.java)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}

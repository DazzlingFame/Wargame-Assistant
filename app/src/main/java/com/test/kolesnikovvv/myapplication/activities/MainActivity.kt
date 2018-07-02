package com.test.kolesnikovvv.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.adapters.MainListingAdapter
import com.test.kolesnikovvv.myapplication.objects.Unit
import com.test.kolesnikovvv.myapplication.objects.UnitData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val items: ArrayList<Unit> = UnitData().necrons

        viewManager = LinearLayoutManager(this)
        viewAdapter = MainListingAdapter(items, {unitItem: Unit -> unitItemClicked(unitItem)})

        recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun unitItemClicked(unitItem: Unit) {
        val intent = Intent(this, BigCardActivity::class.java)
        intent.putExtra("name", unitItem.name)
        intent.putExtra("stats", unitItem.stats)
        intent.putExtra("image", unitItem.image.toString())
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_necrons -> {
                viewAdapter = MainListingAdapter(UnitData().necrons, {unitItem: Unit -> unitItemClicked(unitItem)})

                recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }

                drawer_imageView.setImageResource(R.drawable.necron_warrior)
            }
            R.id.nav_admechs -> {
                viewAdapter = MainListingAdapter(UnitData().adeptusMechanicus, {unitItem: Unit -> unitItemClicked(unitItem)})

                recyclerView = findViewById<RecyclerView>(R.id.rv_main).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }

                drawer_imageView.setImageResource(R.drawable.necron_cryptek)
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

package com.test.kolesnikovvv.myapplication.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.adapters.MissionListingAdapter
import com.test.kolesnikovvv.myapplication.objects.TurnPoints
import com.test.kolesnikovvv.myapplication.objects.UnitData

import kotlinx.android.synthetic.main.activity_mission_meter.*

class MissionMeter : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    var gameData = arrayListOf(TurnPoints())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_meter)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        viewManager = LinearLayoutManager(this)
        viewAdapter = MissionListingAdapter(gameData)

        recyclerView = findViewById<RecyclerView>(R.id.rv_mission_meter).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        recyclerView.itemAnimator = DefaultItemAnimator()


        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = getColor(R.color.colorPrimaryDark)


        fab.setOnClickListener { view ->
            gameData.add(TurnPoints(gameData.lastIndex + 2))

            viewAdapter = MissionListingAdapter(gameData)

            recyclerView = findViewById<RecyclerView>(R.id.rv_mission_meter).apply {

                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

package com.raeandres.cartrackapp.feature.countries.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseActivity
import com.raeandres.cartrackapp.common.utilities.InjectorUtil
import com.raeandres.cartrackapp.feature.countries.adapter.CountryListRecyclerViewAdapter

class CountrySelectionActivity : BaseActivity() {

    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mAdapter : CountryListRecyclerViewAdapter
    private lateinit var viewModel : CountrySelectionViewModel

    companion object {
        fun startActivity(origin: Context) {
            origin.startActivity(Intent(origin, CountrySelectionActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_selection)
        title = ""

        this.setFinishOnTouchOutside(false)

        viewModel = ViewModelProviders.of(this,InjectorUtil.provideCountryList())
            .get(CountrySelectionViewModel::class.java)

        mRecyclerView = findViewById(R.id.select_country_recycler_view)

    }

    override fun onResume() {
        super.onResume()


        viewModel.populateCountryList(this, countries = {
            Log.d("country list: ","country list: $it")

            it.forEach {
                country ->
                Log.d("Country", "country code: ${country.code}")
                Log.d("Country", "country name: ${country.name}")
                Log.d("Country", "country flag: ${country.flag}")

            }

            mAdapter = CountryListRecyclerViewAdapter(this,it)
            mRecyclerView.adapter = mAdapter
            mRecyclerView.layoutManager = LinearLayoutManager(this)
            mAdapter.notifyDataSetChanged()
        })

    }
}
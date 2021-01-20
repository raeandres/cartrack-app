package com.raeandres.cartrackapp.feature.countries.adapter

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Country
import com.raeandres.cartrackapp.feature.auth.login.ui.LoginActivity

const val COUNTRY_PREFIX_KEY = "country_prefix"
const val COUNTRY_FLAG_KEY = "country_flag"
const val COUNTRY_NAME_KEY = "country_name"

class CountryListRecyclerViewAdapter (private val activity: Activity, private val countryList:List<Country>) :
        RecyclerView.Adapter<CountryListRecyclerViewAdapter.CountryListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_select_country,parent,false)

        return CountryListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {

        holder.prefix.text = countryList[position].code
        holder.flag.text = countryList[position].flag
        holder.countryName.text = countryList[position].name

        holder.cardView.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(COUNTRY_PREFIX_KEY, countryList[position].code)
            bundle.putString(COUNTRY_FLAG_KEY,countryList[position].flag )
            bundle.putString(COUNTRY_NAME_KEY, countryList[position].name)

           LoginActivity.startActivity(activity,bundle)
        }
    }

    override fun getItemCount(): Int {
        return if (countryList.isNotEmpty()) countryList.size else 0
    }

    class CountryListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prefix : TextView = itemView.findViewById(R.id.item_select_country_prefix)
        val flag : TextView = itemView.findViewById(R.id.item_select_country_flag_tv)
        val countryName : TextView = itemView.findViewById(R.id.item_select_country_name_tv)

        val cardView : CardView = itemView.findViewById(R.id.item_select_country_cardview)
    }
}
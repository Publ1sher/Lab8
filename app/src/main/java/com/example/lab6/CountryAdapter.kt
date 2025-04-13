package com.example.lab6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val countries: List<Country>,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flag: ImageView = view.findViewById(R.id.flagImageView)
        val name: TextView = view.findViewById(R.id.countryNameTextView)
        val population: TextView = view.findViewById(R.id.populationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.flag.setImageResource(country.flagResId)
        holder.name.text = country.name
        holder.population.text = "Population: ${country.population}"


        holder.itemView.setOnClickListener {
            onItemClick(country)
        }
    }

    override fun getItemCount() = countries.size
}

package com.example.lab6

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val selectedTextView: TextView = findViewById(R.id.selectedCountryTextView)

        val countries = listOf(
            Country("Vietnam", "98,000,000", R.drawable.images),
            Country("United States", "320,000,000", R.drawable.usa),
            Country("Russia", "142,000,000", R.drawable.russia)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountryAdapter(countries) { selectedCountry ->
            selectedTextView.text = "Selected: ${selectedCountry.name} (Population: ${selectedCountry.population})"
            selectedTextView.visibility = TextView.VISIBLE
        }
    }
}
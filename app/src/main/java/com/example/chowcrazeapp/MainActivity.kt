package com.example.chowcrazeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.adapters.RestaurantAdapter
import com.example.chowcrazeapp.models.Restaurant
import com.example.chowcrazeapp.ui.RestaurantActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var intent:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.restaurant_recycler_view)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = RestaurantAdapter(Restaurant.restaurants){restaurant ->
            Log.i("MainActivity", "Restaurant clicked: ${restaurant.name}")
            intent = Intent(this, RestaurantActivity::class.java).apply {
                putExtra("restaurantId", restaurant.id)
            }
            startActivity(intent)
        }
    }
}
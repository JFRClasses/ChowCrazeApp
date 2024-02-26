package com.example.chowcrazeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Restaurant
import org.w3c.dom.Text
import kotlin.properties.Delegates

class RestaurantActivity : AppCompatActivity() {
    private lateinit var restaurantName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        val restaurantId = intent.getIntExtra("restaurantId", 0)
        val restaurant = Restaurant.restaurants.find { it.id == restaurantId }

        restaurantName = findViewById(R.id.restaurant_name)
        restaurantName.text = restaurant?.name

    }
}
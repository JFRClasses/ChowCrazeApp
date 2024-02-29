package com.example.chowcrazeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.adapters.FoodAdapter
import com.example.chowcrazeapp.models.Food
import com.example.chowcrazeapp.models.Restaurant
import org.w3c.dom.Text
import kotlin.properties.Delegates

class RestaurantActivity : AppCompatActivity() {
    private lateinit var restaurantName : TextView
    private lateinit var foodRecyclerView : RecyclerView
    private lateinit var foodIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        val restaurantId = intent.getIntExtra("restaurantId", 0)
        val restaurant = Restaurant.restaurants.find { it.id == restaurantId }
        val foods = Food.foods.filter { it.restaurantId == restaurantId }
        restaurantName = findViewById(R.id.restaurant_name)
        restaurantName.text = restaurant?.name
        foodRecyclerView = findViewById(R.id.foods_recyclerview)
        setUpRecyclerView(foods)
    }

    fun setUpRecyclerView(foods:List<Food>){
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
        foodRecyclerView.adapter = FoodAdapter(foods){ food ->
            Log.i("MainActivity", "Food clicked: ${food.name}")
            foodIntent = Intent(this, FoodDetailActivity::class.java).apply {
                putExtra("foodId", food.id)
            }
            startActivity(foodIntent)
        }
    }
}
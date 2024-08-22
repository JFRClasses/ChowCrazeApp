package com.example.chowcrazeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.adapters.CategoryAdapter
import com.example.chowcrazeapp.adapters.FoodAdapter
import com.example.chowcrazeapp.adapters.RestaurantAdapter
import com.example.chowcrazeapp.models.Category
import com.example.chowcrazeapp.models.Food
import com.example.chowcrazeapp.models.Restaurant
import com.example.chowcrazeapp.ui.FoodDetailActivity
import com.example.chowcrazeapp.ui.LoginActivity
import com.example.chowcrazeapp.ui.RestaurantActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var foodRecyclerView: RecyclerView
    private lateinit var logOutImg: ImageView
    private lateinit var intent:Intent
    private lateinit var foodIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = getSharedPreferences("mypref", MODE_PRIVATE)
        recyclerView = findViewById(R.id.restaurant_recycler_view)
        categoryRecyclerView = findViewById(R.id.category_recycler_view)
        foodRecyclerView = findViewById(R.id.food_recycler_view)
        logOutImg = findViewById(R.id.logoutButton)
        logOutImg.setOnClickListener {
            val editor = sharedPref.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        setUpRecyclerView()
        setUpCategoryRecyclerView()
        setUpFoodRecyclerView()
    }

    private fun setUpFoodRecyclerView() {
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
        val foods = Food.foods.filter { it.rating > 4.5 }
        foodRecyclerView.adapter = FoodAdapter(foods){ food ->
            Log.i("MainActivity", "Food clicked: ${food.name}")
            foodIntent = Intent(this, FoodDetailActivity::class.java).apply {
                putExtra("foodId", food.id)
            }
            startActivity(foodIntent)
        }
    }

    private fun setUpCategoryRecyclerView() {
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.adapter = CategoryAdapter(Category.categories){ category ->
            Log.i("MainActivity", "Category clicked: ${category.name}")
            Snackbar.make(categoryRecyclerView, "Category clicked: ${category.name}", Snackbar.LENGTH_LONG).show()
        }
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
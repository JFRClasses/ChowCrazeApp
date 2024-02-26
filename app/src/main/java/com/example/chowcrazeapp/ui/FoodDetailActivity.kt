package com.example.chowcrazeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Food
import com.example.chowcrazeapp.models.FoodCategory

class FoodDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val categoryId = intent.getIntExtra("categoryId", 0)

        val foodIds = FoodCategory.foodCategories.filter { it.categoryId == categoryId }
            .map { it.foodId }
        val foods = Food.foods.filter { food ->
            foodIds.any { it == food.id }
        }
    }
}
package com.example.chowcrazeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Food
import com.example.chowcrazeapp.models.FoodCategory
import com.squareup.picasso.Picasso

class FoodDetailActivity : AppCompatActivity() {
    private lateinit var foodImageView: ImageView
    private lateinit var foodName: TextView
    private lateinit var foodPrice: TextView
    private lateinit var foodRating: TextView
    private lateinit var foodDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        foodImageView = findViewById(R.id.burgerImage)
        foodName = findViewById(R.id.food_title)
        foodPrice = findViewById(R.id.food_price)
        foodRating = findViewById(R.id.ratingTxt)
        foodDescription = findViewById(R.id.food_description)
        val foodId = intent.getIntExtra("foodId", 0)
        Food.foods.find { it.id == foodId }.let { food: Food? ->
            Picasso.get().load(food?.image).into(foodImageView)
            foodName.text = food?.name
            foodPrice.text = food?.priceFormatted
            foodRating.text = food?.rating.toString()
            foodDescription.text = food?.description
        }
    }
}
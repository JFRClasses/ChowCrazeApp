package com.example.chowcrazeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.models.Food
import com.squareup.picasso.Picasso

class FoodAdapter(private val foods:List<Food>, val onClick:(Food)->Unit): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>()
{
    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodPrice: TextView = itemView.findViewById(R.id.foodPrice)
        val foodRating: TextView = itemView.findViewById(R.id.foodRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.foodName.text = food.name
        holder.foodPrice.text = food.priceFormatted
        holder.foodRating.text = food.rating.toString()
        Picasso.get().load(food.image).into(holder.foodImage)
        holder.itemView.setOnClickListener {
            onClick(food)
        }
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}
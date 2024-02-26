package com.example.chowcrazeapp.models

data class FoodCategory(val foodId: Int, val categoryId: Int) {
    companion object {
        val foodCategories = mutableListOf<FoodCategory>(
            FoodCategory(1, 1),
            FoodCategory(2, 1),
            FoodCategory(3, 1),
            FoodCategory(4, 1),
            FoodCategory(5, 1),
            FoodCategory(6, 1),
            FoodCategory(7, 3),
            FoodCategory(8, 3),
            FoodCategory(9, 5),
            FoodCategory(10, 5)
        )
    }
}

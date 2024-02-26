package com.example.chowcrazeapp.models

data class Category(val id:Int,val name:String){
    companion object{
        val categories = mutableListOf<Category>(
            Category(1,"Fast Food"),
            Category(2,"Chinese"),
            Category(3,"Italian"),
            Category(4,"Mexican"),
            Category(5,"American"),
        )
    }
}

package com.example.chowcrazeapp.mock

import com.example.chowcrazeapp.models.User

class MockData {

    companion object{
        val users = listOf<User>(
            User("juanfr97@hotmail.com","123456"),
            User("juanfr98@hotmail.com","123456"),
            User("juanfr99@hotmail.com","123456")
        )
    }
}
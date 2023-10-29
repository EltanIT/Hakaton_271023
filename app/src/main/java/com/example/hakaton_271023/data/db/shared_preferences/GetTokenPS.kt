package com.example.hakaton_271023.data.db.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.util.Log

class GetTokenPS {

    private lateinit var sharedPreferences: SharedPreferences

    fun request(context: Context): String?{

        sharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token", null) ?: return null
        Log.i("token", token)
        return token

    }

}
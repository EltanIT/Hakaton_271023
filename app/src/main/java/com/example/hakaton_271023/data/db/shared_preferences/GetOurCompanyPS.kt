package com.example.hakaton_271023.data.db.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class GetOurCompanyPS {

    private lateinit var sharedPreferences: SharedPreferences

    fun request(context: Context): String?{

        sharedPreferences = context.getSharedPreferences("Portal", Context.MODE_PRIVATE)

        return sharedPreferences.getString("company", null)

    }

}
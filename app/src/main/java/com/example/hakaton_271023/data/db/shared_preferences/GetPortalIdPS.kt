package com.example.hakaton_271023.data.db.shared_preferences

import android.content.Context
import android.content.SharedPreferences

class GetPortalIdPS {

    private lateinit var sharedPreferences: SharedPreferences

    fun request(context: Context): String?{

        sharedPreferences = context.getSharedPreferences("Portal", Context.MODE_PRIVATE)
        return sharedPreferences.getString("portal", null)

    }

}
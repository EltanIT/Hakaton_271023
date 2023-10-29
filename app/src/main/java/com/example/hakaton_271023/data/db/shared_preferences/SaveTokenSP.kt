package com.example.hakaton_271023.data.db.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SaveTokenSP {

    private lateinit var sharedPreferences: SharedPreferences

    fun request(context: Context, token: String){

        sharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()

        editor.remove("token")
        editor.putString("token", token)
        editor.commit()


    }

}
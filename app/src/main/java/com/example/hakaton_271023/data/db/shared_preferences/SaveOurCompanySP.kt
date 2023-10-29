package com.example.hakaton_271023.data.db.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SaveOurCompanySP {

    private lateinit var sharedPreferences: SharedPreferences

    fun request(context: Context, company: String){

        sharedPreferences = context.getSharedPreferences("Portal", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()

        editor.remove("company")
        editor.putString("company", company)
        editor.commit()


    }

}
package com.example.hakaton_271023.data.db.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SavePortalIdSP {

    private lateinit var sharedPreferences: SharedPreferences

    fun request(context: Context, id: String){

        sharedPreferences = context.getSharedPreferences("Portal", Context.MODE_PRIVATE)
        Log.i("id_port", id)
        val editor = sharedPreferences.edit()

        editor.remove("portal")
        editor.putString("portal", id)
        editor.putString("owner", id)
        editor.commit()


    }

}
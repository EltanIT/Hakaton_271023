package com.example.hakaton_271023.domain.usecase

import android.content.Context
import com.example.hakaton_271023.data.db.shared_preferences.SavePortalIdSP
import com.google.gson.Gson

class SavePortalLocalUseCase {

    private val saveOurPortalSP = SavePortalIdSP()
    fun execute(id: String?, context: Context): Boolean {
        val gson = Gson()
        val body = gson.toJson(id)
        saveOurPortalSP.request(context, body)
        return true

    }
}
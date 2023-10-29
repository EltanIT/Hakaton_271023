package com.example.hakaton_271023.data.db

import android.util.Log
import com.example.hakaton_271023.config.URLs
import com.example.hakaton_271023.domain.model.OurPortalModel
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class CreatePortalDBRepositoryImpl{

    private val url = URLs().createPortalsURL
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    fun request(portalModel: RegistrationPortalModel): String?{

        val client = OkHttpClient()
        val gson = Gson()

        val mapData= mapOf(
            "email" to portalModel.email,
            "password" to portalModel.password,
            "name" to portalModel.name,
            "phone_number" to portalModel.phone_number,
            "inn" to portalModel.inn,
            "address" to portalModel.address
        )

        val data = gson.toJson(mapData)

        val requestBody = data.toRequestBody(mediaType)

        val request = Request.Builder().url(url)
            .post(requestBody)
            .build()

        try{
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful){
                    return response.body?.string()
                }
                Log.d("code", response.code.toString())

            }
        }catch (e: IOException){
            return null
        }
        return null

    }
}
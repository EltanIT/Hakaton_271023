package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException


class DowngradeEmployeePortalDBRepositoryImpl{

    private val url = URLs().downgradeEmployeePortalsURL
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    fun request(id: String, token: String): Boolean{

        val client = OkHttpClient()
        val gson = Gson()

        val mapData= mapOf(
            "user_id" to id
        )

        val data = gson.toJson(mapData)

        val requestBody = data.toRequestBody(mediaType)

        val request = Request.Builder().url(url)
            .post(requestBody)
            .header("authorization", token)
            .build()

        try{
            client.newCall(request).execute().use { response ->
                return response.isSuccessful
            }
        }catch (e: IOException){
            return false
        }
        return false

    }
}
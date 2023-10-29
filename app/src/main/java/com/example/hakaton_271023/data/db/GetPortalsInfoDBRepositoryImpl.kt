package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.net.URL


class GetPortalsInfoDBRepositoryImpl{

    private val url = URLs().portalInfoURL
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    fun request(token: String, id: String): String?{
        val url1 = URL(url.toString()+"?portal_id=$id")
        val client = OkHttpClient()
        val gson = Gson()

        val mapData= mapOf(
            "name" to "",
            "phone_number" to "",
            "inn" to "",
            "address" to "",
            "color" to "",
            "purpose" to "",
            "mission" to "",
            "description" to ""
        )

        val data = gson.toJson(mapData)

        val requestBody = data.toRequestBody(mediaType)

        val request = Request.Builder().url(url1)
            .put(requestBody)
            .header("Authorization", token)
            .build()

        try{
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful){
                    return response.body?.string()
                }

            }
        }catch (e: IOException){
            return null
        }
        return null

    }
}
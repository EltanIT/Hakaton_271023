package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import com.example.hakaton_271023.domain.model.RegistrationUserModel
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class RegistrationUserDBRepositoryImpl{
    private val url = URLs().registrationUserUrl
    private val mediaType = "application/json; charset=utf-8".toMediaType()
    fun request(registeringProfile: RegistrationUserModel): String?{

        val client = OkHttpClient()
        val gson = Gson()

        val mapData: Map<String, String> = mapOf(
            "email" to "usergerfdafdafa@gmail.com",
            "password" to "123456"
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
                return null
            }
        }catch (e: IOException){
            return null
        }
    }
}
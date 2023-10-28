package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class GetProfileDBRepositoryImpl{

    private val url = URLs().loginUserURL
    fun request(token: String): String?{

        val client = OkHttpClient()

        val request = Request.Builder().url(url)
            .get()
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
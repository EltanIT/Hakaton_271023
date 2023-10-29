package com.example.hakaton_271023.data.db

import android.util.Log
import com.example.hakaton_271023.config.URLs
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class GetAllTestsDBRepositoryImpl{

    private val url = URLs().getAllTestsURL
    fun request(token: String): String?{

        val client = OkHttpClient()

        val request = Request.Builder().url(url)
            .get()
            .header("authorization", token)
            .build()

        try{
            client.newCall(request).execute().use { response ->
                val body = response.body?.string()
                Log.i("getAllTests", body.toString())
                if (response.isSuccessful){
                    return body
                }

            }
        }catch (e: IOException){
            return null
        }
        return null

    }
}
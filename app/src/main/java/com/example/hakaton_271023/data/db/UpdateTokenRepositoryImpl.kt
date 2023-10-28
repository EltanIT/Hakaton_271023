package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class UpdateTokenRepositoryImpl{

    private val url = URLs().simpleGetURL
    fun request(): String?{

        val client = OkHttpClient()

        val request = Request.Builder().url(url)
            .get()
            .build()

        try{
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful){

                    return response.body?.string()
                }
                else{
                    return null
                }
            }
        }catch (e: IOException){
            return null
        }


    }
}
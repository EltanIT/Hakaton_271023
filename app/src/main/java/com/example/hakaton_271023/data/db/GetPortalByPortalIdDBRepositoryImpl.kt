package com.example.hakaton_271023.data.db

import android.util.Log
import com.example.hakaton_271023.config.URLs
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.URL


class GetPortalByPortalIdDBRepositoryImpl{

    private val url = URLs().getAllPortalByIdURL
    fun request(id:String, token: String): String?{
        val url1 = URL(url+id)
        val client = OkHttpClient()

        val request = Request.Builder().url(url1)
            .get()
            .header("authorization", token)
            .build()

        try{
            client.newCall(request).execute().use { response ->
                val body = response.body?.string()
                Log.i("getPortalById", body.toString())
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
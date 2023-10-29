package com.example.hakaton_271023.data.db

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.hakaton_271023.config.URLs
import com.example.hakaton_271023.domain.model.LoginUserModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.Base64

class LoginUserDBRepositoryImpl{

    private val url = URLs().loginUserURL
    private val mediaType = "application/json; charset=utf-8".toMediaType()
    @RequiresApi(Build.VERSION_CODES.O)
    fun request(loginUserModel: LoginUserModel): String?{

        val client = OkHttpClient()
        val gson = Gson()

        val mapData= mapOf(
        "email" to loginUserModel.email,
        "password" to loginUserModel.password)

        val data = gson.toJson(mapData)

        val requestBody = data.toRequestBody(mediaType)
        val request = Request.Builder().url(url)
            .post(requestBody)
            .build()

        try{
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful){
                    Log.w("errorserver",response.code.toString())
                    return response.body?.string()
                }
                Log.i("errorserver",response.code.toString())
            }
        }catch (e: IOException){
            return null
        }
        return null
    }
}

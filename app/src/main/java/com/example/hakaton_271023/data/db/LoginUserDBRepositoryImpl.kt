package com.example.hakaton_271023.data.db

import android.os.Build
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
    fun request(loginUserModel: LoginUserModel): Boolean{

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
                val objectMapper = ObjectMapper()
                val responseBody = response.body!!.string()

                val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
                    responseBody,
                    HashMap::class.java
                )
                val access_token = stringMap?.get("access_token") as String
                val refresh_token = stringMap?.get("refresh_token") as String
                val token_type = stringMap?.get("token_type" )as String

                val token_part =
                    access_token!!.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                val a = String(Base64.getDecoder().decode(token_part[1]))

                val tokenMap: java.util.HashMap<*, *>? = objectMapper.readValue(
                    a,
                    HashMap::class.java
                )
                val name_role = tokenMap?.get("sub") as String
                val role = name_role!!.substring(name_role.indexOf(":") + 1, name_role.length)
                /////
                return response.isSuccessful
            }
        }catch (e: IOException){
            return false
        }
    }
}

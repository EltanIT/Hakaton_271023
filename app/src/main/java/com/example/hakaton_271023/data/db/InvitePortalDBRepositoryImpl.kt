package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException


class InvitePortalDBRepositoryImpl{

    private val url = URLs().createPortalsURL
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    fun request(portalModel: RegistrationPortalModel, token:String): String?{

        val client = OkHttpClient()
        val gson = Gson()

        val mapData= mapOf(
            "email" to portalModel.email,
            "portal_id" to portalModel.password,
            "department_id" to portalModel.name,
        )

        val data = gson.toJson(mapData)

        val requestBody = data.toRequestBody(mediaType)

        val request = Request.Builder().url(url)
            .post(requestBody)
            .header("authorization", token)
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
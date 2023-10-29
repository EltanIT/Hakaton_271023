package com.example.hakaton_271023.data.db

import android.util.Log
import com.example.hakaton_271023.config.URLs
import com.example.hakaton_271023.domain.model.DepartmentModel
import com.example.hakaton_271023.domain.model.OurPortalModel
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.example.hakaton_271023.domain.model.TestModel
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException


class CreateTestslDBRepositoryImpl{

    private val url = URLs().createTestURL
    private val mediaType = "application/json; charset=utf-8".toMediaType()

    fun request(token: String, testModel: TestModel): Boolean{

        val client = OkHttpClient()
        val gson = Gson()

        val mapData= mapOf(
            "name" to testModel.name,
            "module_name" to testModel.module_name,
            "questions" to testModel.questions,
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
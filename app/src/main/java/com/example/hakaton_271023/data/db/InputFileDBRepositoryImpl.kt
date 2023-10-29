package com.example.hakaton_271023.data.db

import com.example.hakaton_271023.config.URLs
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.File
import java.io.IOException


class InputFileDBRepositoryImpl{

//    private val url = URLs().createPortalsURL
//    fun request(file: File): Boolean{
//
//        val client = OkHttpClient()
//
//        val requestFile = RequestBody.create("application/octet-stream".toMediaTypeOrNull(), file)
//
//        val request = Request.Builder().url(url)
//            .post(requestFile)
//            .build()
//
//        try{
//            client.newCall(request).execute().use { response ->
//                return response.isSuccessful
//            }
//        }catch (e: IOException){
//            return false
//        }
//
//
//    }
}
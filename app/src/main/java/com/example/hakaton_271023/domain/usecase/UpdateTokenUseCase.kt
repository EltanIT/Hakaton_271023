package com.example.hakaton_271023.domain.usecase

import com.example.hakaton_271023.data.db.UpdateTokenRepositoryImpl
import com.fasterxml.jackson.databind.ObjectMapper

class UpdateTokenUseCase {

    private val updateTokenRepositoryImpl = UpdateTokenRepositoryImpl()
//    fun execute(refreshToken: String): Boolean{
//        val body = updateTokenRepositoryImpl.request()
//        if (body != null){
//            val objectMapper = ObjectMapper()
//            val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
//                body,
//                HashMap::class.java
//            )
//            val tokenPair:HashMap<*,*> = stringMap?.get("tokenPair") as HashMap<*, *>
//            val role: String = stringMap?.get("role") as String
//
//            val accessToken = tokenPair?.get("accessToken") as String
//            if (accessToken.isNotEmpty()){
//                return true
//            }
//        }
//        return false
//
//
//    }

}
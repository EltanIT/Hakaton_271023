package com.example.hakaton_271023.domain.usecase

import com.example.hakaton_271023.data.db.LoginUserDBRepositoryImpl
import com.example.hakaton_271023.data.db.RegistrationUserDBRepositoryImpl
import com.example.hakaton_271023.domain.model.LoginUserModel
import com.example.hakaton_271023.domain.model.RegistrationUserModel
import com.fasterxml.jackson.databind.ObjectMapper

class RegistrationUserUseCase {

    private val registrationUserDBRepositoryImpl = RegistrationUserDBRepositoryImpl()
    fun execute(registrationUserModel: RegistrationUserModel): Boolean{
        val body = registrationUserDBRepositoryImpl.request(registrationUserModel) ?: return false
        val objectMapper = ObjectMapper()
        val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
            body,
            HashMap::class.java
        )
        val tokenPair:HashMap<*,*> = stringMap?.get("tokenPair") as HashMap<*, *>
        val role: String = stringMap?.get("role") as String

        val accessToken = tokenPair?.get("accessToken") as String
        if (accessToken.isEmpty()){
            return false
        }
        return true


    }
}
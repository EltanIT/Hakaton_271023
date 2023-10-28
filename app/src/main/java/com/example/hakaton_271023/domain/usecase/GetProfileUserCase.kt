package com.example.hakaton_271023.domain.usecase

import com.example.hakaton_271023.data.db.GetProfileDBRepositoryImpl
import com.example.hakaton_271023.domain.model.ProfileModel
import com.fasterxml.jackson.databind.ObjectMapper

class GetProfileUserCase {

    private val getProfileDB = GetProfileDBRepositoryImpl()
    fun execute(token: String): ProfileModel? {
        val body = getProfileDB.request(token) ?: return null

        val objectMapper = ObjectMapper()
        val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
            body,
            HashMap::class.java
        )
        val email = stringMap?.get("email") as String
        val role = stringMap?.get("role") as String
        val urlIcon = stringMap?.get("urlIcon") as String
        return ProfileModel(email, role, urlIcon)
    }
}
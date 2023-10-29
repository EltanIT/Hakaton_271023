package com.example.hakaton_271023.domain.usecase

import android.content.Context
import com.example.hakaton_271023.data.db.GetAllTestsDBRepositoryImpl
import com.example.hakaton_271023.data.db.GetProfileDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.GetTokenPS
import com.example.hakaton_271023.domain.model.PortalModel
import com.example.hakaton_271023.domain.model.ProfileModel
import com.example.hakaton_271023.domain.model.TestModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType

class GetAllTestUserCase {

    private val getAllTestsDBRepositoryImpl = GetAllTestsDBRepositoryImpl()
    private val getTokenSP = GetTokenPS()
    fun execute(context: Context): ArrayList<TestModel>? {
        val token = getTokenSP.request(context) ?: return null
        val body = getAllTestsDBRepositoryImpl.request(token) ?: return null

        val objectMapper = ObjectMapper()
        return try {
            val listType: CollectionType = objectMapper.typeFactory.constructCollectionType(
                java.util.ArrayList::class.java,
                TestModel::class.java
            )
            objectMapper.readValue<List<TestModel>>(body, listType) as ArrayList
        } catch (e: Exception) {
            throw e
//                null
        }
    }
}
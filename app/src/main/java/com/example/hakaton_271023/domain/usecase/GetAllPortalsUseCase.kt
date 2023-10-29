package com.example.hakaton_271023.domain.usecase

import android.content.Context
import android.util.Log
import com.example.hakaton_271023.data.db.GetAllPortalsDBRepositoryImpl
import com.example.hakaton_271023.data.db.GetMyPortalsDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.GetTokenPS
import com.example.hakaton_271023.data.db.shared_preferences.SavePortalIdSP
import com.example.hakaton_271023.domain.model.OurPortalModel
import com.example.hakaton_271023.domain.model.PortalModel
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType

class GetAllPortalsUseCase {

    private val getAllPortalsDB = GetAllPortalsDBRepositoryImpl()
    private val getTokenSP = GetTokenPS()
    fun execute(context:Context): ArrayList<PortalModel>? {
        val token = getTokenSP.request(context)
        if (token!= null){
            val body = getAllPortalsDB.request()
            val objectMapper = ObjectMapper()

            return try {
                val listType: CollectionType = objectMapper.typeFactory.constructCollectionType(
                    java.util.ArrayList::class.java,
                    PortalModel::class.java
                )
                objectMapper.readValue<List<PortalModel>>(body, listType) as ArrayList
            } catch (e: Exception) {
                throw e
//                null
            }
        }
        return null


    }
}
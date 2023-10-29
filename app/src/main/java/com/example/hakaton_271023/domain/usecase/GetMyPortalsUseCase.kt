package com.example.hakaton_271023.domain.usecase

import android.content.Context
import com.example.hakaton_271023.data.db.GetMyPortalsDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.GetTokenPS
import com.example.hakaton_271023.domain.model.OurPortalModel
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType

class GetMyPortalsUseCase {

    private val getMyPortalsDB = GetMyPortalsDBRepositoryImpl()
    private val getTokenSP = GetTokenPS()
    fun execute(context:Context): ArrayList<OurPortalModel>? {
        val token = getTokenSP.request(context)
        if (token!= null){
            val body = getMyPortalsDB.request(token)
            val objectMapper = ObjectMapper()

            return try {
                val listType: CollectionType = objectMapper.typeFactory.constructCollectionType(
                    java.util.ArrayList::class.java,
                    OurPortalModel::class.java
                )

                objectMapper.readValue<List<OurPortalModel>>(body, listType) as ArrayList
            } catch (e: Exception) {
                null
            }
        }
        return null


    }
}
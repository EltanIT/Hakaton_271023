package com.example.hakaton_271023.domain.usecase

import android.content.Context
import com.example.hakaton_271023.data.db.GetPortalByPortalIdDBRepositoryImpl
import com.example.hakaton_271023.data.db.GetPortalsInfoDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.GetPortalIdPS
import com.example.hakaton_271023.data.db.shared_preferences.GetTokenPS
import com.example.hakaton_271023.data.db.shared_preferences.SaveOurCompanySP
import com.example.hakaton_271023.domain.model.OurCompanyModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson

class GetPortalByIdUseCase {

    private val getPortalByPortalIdDBRepositoryImpl = GetPortalByPortalIdDBRepositoryImpl()
    private val saveOurCompanySP = SaveOurCompanySP()
    private val getTokenSP = GetTokenPS()
    private val getPortalIdSP = GetPortalIdPS()

    fun execute(context: Context): OurCompanyModel? {
        val token = getTokenSP.request(context)
        val id = getPortalIdSP.request(context)
        if (token != null && id != null){
            val body = getPortalByPortalIdDBRepositoryImpl.request(id,token)
            try {
                val objectMapper = ObjectMapper()
                val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
                    body,
                    HashMap::class.java
                )
                val name = stringMap?.get("name") as String
                val phone_number = stringMap?.get("phone_number") as String
                val inn = stringMap?.get("inn") as String
                val address = stringMap?.get("address") as String
                val color = stringMap?.get("color") as String
                val purpose = stringMap?.get("purpose") as String
                val mission = stringMap?.get("mission") as String
                val description = stringMap?.get("description") as String

                val ourCompanyModel = OurCompanyModel(name, phone_number, inn, address,color, purpose,mission,description)

                val gson = Gson()
                saveOurCompanySP.request(context, gson.toJson(ourCompanyModel))

                return ourCompanyModel
            } catch (e: Exception) {
                return null
            }
        }
        return null

    }
}
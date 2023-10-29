package com.example.hakaton_271023.domain.usecase

import android.content.Context
import com.example.hakaton_271023.data.db.CreatePortalDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.SavePortalIdSP
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.fasterxml.jackson.databind.ObjectMapper

class CreatePortalsUseCase {

    private val createPortalDBRepositoryImpl = CreatePortalDBRepositoryImpl()
    private val savePortalIdSP = SavePortalIdSP()
    fun execute(portalModel: RegistrationPortalModel, context: Context): Boolean {
        val body = createPortalDBRepositoryImpl.request(portalModel)

        val objectMapper = ObjectMapper()
        if (body!= null){
            val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
                body,
                HashMap::class.java
            )
            val id: String = stringMap?.get("id_") as String
            savePortalIdSP.request(context, id)
            return true
        }
        return false

    }
}
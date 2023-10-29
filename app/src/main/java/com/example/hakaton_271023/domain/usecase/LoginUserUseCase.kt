package com.example.hakaton_271023.domain.usecase

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.hakaton_271023.data.db.LoginUserDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.SaveTokenSP
import com.example.hakaton_271023.domain.model.LoginUserModel
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.Base64

class LoginUserUseCase {

    private val loginUserDB = LoginUserDBRepositoryImpl()
    private val saveTokenPS = SaveTokenSP()
    @RequiresApi(Build.VERSION_CODES.O)
    fun execute(loginUserModel: LoginUserModel, context: Context): String?{
        val objectMapper = ObjectMapper()
        val responseBody = loginUserDB.request(loginUserModel)

        if (responseBody!= null){
            val stringMap: java.util.HashMap<*, *>? = objectMapper.readValue(
                responseBody,
                HashMap::class.java
            )
            val tokenPair:HashMap<*,*> = stringMap?.get("tokenPair") as HashMap<*, *>
            val role: String = stringMap?.get("role") as String

            val accessToken = tokenPair?.get("accessToken") as String
            if (accessToken.isNotEmpty()){
                saveTokenPS.request(context = context, accessToken)
                return role
            }
            return null
        }

        return null
    }
}
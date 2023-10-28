package com.example.hakaton_271023.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.hakaton_271023.data.db.LoginUserDBRepositoryImpl
import com.example.hakaton_271023.domain.model.LoginUserModel

class LoginUserUseCase {

    private val loginUserDB = LoginUserDBRepositoryImpl()
    @RequiresApi(Build.VERSION_CODES.O)
    fun execute(loginUserModel: LoginUserModel): Boolean{
        return loginUserDB.request(loginUserModel)
    }
}
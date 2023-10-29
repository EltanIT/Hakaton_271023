package com.example.hakaton_271023.domain.usecase

import android.content.Context
import com.example.hakaton_271023.data.db.CreateDepartmentPortalDBRepositoryImpl
import com.example.hakaton_271023.data.db.CreateTestslDBRepositoryImpl
import com.example.hakaton_271023.data.db.shared_preferences.GetTokenPS
import com.example.hakaton_271023.domain.model.DepartmentModel
import com.example.hakaton_271023.domain.model.TestModel

class CreateTestUseCase {

    private val createTestsDBRepositoryImpl = CreateTestslDBRepositoryImpl()
    private val getTokenPS = GetTokenPS()
    fun execute(testModel: TestModel, context: Context): Boolean {
        val token = getTokenPS.request(context = context)
        if (token != null){
            return createTestsDBRepositoryImpl.request(token, testModel)
        }
       return false
    }
}
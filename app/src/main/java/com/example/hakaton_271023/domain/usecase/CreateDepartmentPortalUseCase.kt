package com.example.hakaton_271023.domain.usecase

import com.example.hakaton_271023.data.db.CreateDepartmentPortalDBRepositoryImpl
import com.example.hakaton_271023.domain.model.DepartmentModel

class CreateDepartmentPortalUseCase {

    private val createDepartmentPortalDBRepositoryImpl = CreateDepartmentPortalDBRepositoryImpl()
    fun execute(departmentModel: DepartmentModel, token: String): Boolean {
        return createDepartmentPortalDBRepositoryImpl.request(token, departmentModel)


    }
}
package com.example.hakaton_271023.domain.usecase

import com.example.hakaton_271023.data.db.InputFileDBRepositoryImpl
import java.io.File

class InputFileUseCase {

    private val inputFileDBRepositoryImpl = InputFileDBRepositoryImpl()
    fun execute(file: File): Boolean {
        return inputFileDBRepositoryImpl.request(file)
    }

}
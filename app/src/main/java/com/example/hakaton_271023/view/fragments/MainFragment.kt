package com.example.hakaton_271023.view.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.hakaton_271023.databinding.FragmentMainBinding
import com.example.hakaton_271023.domain.model.LoginUserModel
import com.example.hakaton_271023.domain.model.RegistrationUserModel
import com.example.hakaton_271023.domain.usecase.InputFileUseCase
import com.example.hakaton_271023.domain.usecase.LoginUserUseCase
import com.example.hakaton_271023.domain.usecase.RegistrationUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val inputFileUseCase = InputFileUseCase()
    private val registrationUserUseCase = RegistrationUserUseCase()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
//    pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)

    binding.signin.setOnClickListener(View.OnClickListener {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            login()
        }
    })

    binding.registration.setOnClickListener(View.OnClickListener {
        reg()
    })
        return binding.root
    }

    override fun onResume() {
        coroutineScope.launch {
            val result = registrationUserUseCase.execute(RegistrationUserModel())
            withContext(Dispatchers.Main){
                Toast.makeText(context, result.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        super.onResume()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun login(){
        coroutineScope.launch {
            val loginUserUseCase = LoginUserUseCase()
            val result = loginUserUseCase.execute(loginUserModel = LoginUserModel("lolka@gmail.com", "123456"))
            withContext(Dispatchers.Main){
                Toast.makeText(context, "$result", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun reg(){
        coroutineScope.launch {
            val result = registrationUserUseCase.execute(RegistrationUserModel())
            withContext(Dispatchers.Main){
                Toast.makeText(context, "$result", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null){
            Toast.makeText(context, "Выбрано: ${uri.path}", Toast.LENGTH_SHORT).show()
            val file = File(uri?.path)
            coroutineScope.launch {
                val result = inputFileUseCase.execute(file)
                withContext(Dispatchers.Main){
                    Toast.makeText(context, "$result", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else{
            Toast.makeText(context, "Ошибка при выборе файла", Toast.LENGTH_SHORT).show()
        }

    }

}
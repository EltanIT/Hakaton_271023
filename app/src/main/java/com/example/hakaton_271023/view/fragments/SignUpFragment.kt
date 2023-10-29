package com.example.hakaton_271023.view.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentSignupBinding
import com.example.hakaton_271023.domain.model.RegistrationPortalModel
import com.example.hakaton_271023.domain.usecase.CreatePortalsUseCase
import com.example.hakaton_271023.view.activities.CommonSlideBarActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    private var checkPassword = false
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val createPortalsUseCase = CreatePortalsUseCase()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    private fun setting() {
        binding.password.setOnTouchListener(OnTouchListener { view, motionEvent ->
            val DRAWABLE_RIGHT = 2
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (motionEvent.rawX >= binding.password.right - binding.password.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    if (!checkPassword) {
                        binding.password.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            resources.getDrawable(R.drawable.eye_ic),
                            null
                        )
                        binding.password.transformationMethod = null
                        checkPassword = true
                    } else {
                        binding.password.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            resources.getDrawable(R.drawable.eye_slash_ic),
                            null
                        )
                        binding.password.transformationMethod = PasswordTransformationMethod()
                        checkPassword = false
                    }
                    return@OnTouchListener true
                }
            }
            false
        })
        binding.password.addTextChangedListener {
            binding.password.isActivated = it?.toString()?.isEmpty() == false
        }
        binding.email.addTextChangedListener{
            if (it?.toString()?.isEmpty() == false){
                if (!isEmailValid(it.toString())){
                    binding.email.isSelected = true
                    binding.email.isActivated = true
                }
                else{
                    binding.email.isActivated = true
                    binding.email.isSelected = false
                }
            }
            else{
                binding.email.isActivated = false
                binding.email.isSelected = false
            }



        }
        binding.organizationName.addTextChangedListener{
            binding.organizationName.isActivated = it?.toString()?.isEmpty() == false
        }
        binding.tel.addTextChangedListener {
            binding.tel.isActivated = it?.toString()?.isEmpty() == false
        }
        binding.inn.addTextChangedListener{
            binding.inn.isActivated = it?.toString()?.isEmpty() == false
        }
        binding.address.addTextChangedListener{
            binding.address.isActivated = it?.toString()?.isEmpty() == false
        }

        binding.login.setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.signup.setOnClickListener{
            if (checkEt()){
                coroutineScope.launch {
                    val name = binding.organizationName.text.toString()
                    val password = binding.password.text.toString()
                    val tel = binding.tel.text.toString()
                    val inn = binding.inn.text.toString()
                    val address = binding.address.text.toString()
                    val email = binding.email.text.toString()
                    val result = createPortalsUseCase.execute(RegistrationPortalModel(email, password, name, tel, inn, address), requireContext())
                    withContext(Dispatchers.Main){
                        if (result){
                            startActivity(Intent(requireActivity(), CommonSlideBarActivity::class.java))
                        }
                        else{
                            Toast.makeText(context, "Ошибка регистрации", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            else{
                Toast.makeText(context, "Ошибка создания портала", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun checkEt(): Boolean {
        return (isEmailValid(binding.email.text.toString())
                && binding.organizationName.text?.isEmpty() == false
                && binding.password.text?.isEmpty() == false
                && binding.tel.text?.isEmpty() == false
                && binding.inn.text?.isEmpty() == false
                && binding.address.text?.isEmpty() == false
                )
    }

    private fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}
package com.example.hakaton_271023.view.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentLoginBinding
import com.example.hakaton_271023.domain.model.LoginUserModel
import com.example.hakaton_271023.domain.usecase.LoginUserUseCase
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity
import com.example.hakaton_271023.view.activities.CommonSlideBarActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private var checkPassword = false
    private val loginUserUseCase = LoginUserUseCase()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ClickableViewAccessibility")
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
        binding.signup.setOnClickListener(View.OnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, SignUpFragment(), "signUp")
                .addToBackStack("singup")
                .commit()
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

        binding.login.setOnClickListener{
            if (isEmailValid(binding.email.text.toString()) && binding.password.isActivated){
                coroutineScope.launch {
                    val loginUserModel = LoginUserModel(binding.email.text.toString(), binding.password.text.toString())
                    val result = loginUserUseCase.execute(loginUserModel, requireContext())
                    withContext(Dispatchers.Main){
                        if (result != null){
                            Toast.makeText(context, result+"", Toast.LENGTH_SHORT).show()
                            if (result == "Common"){
                                val bundle = Bundle()
                                bundle.putString("role", result)
                                val choosePortalFragment = ChoosePortalFragment()
                                choosePortalFragment.arguments = bundle
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .add(R.id.main_fragment_container, choosePortalFragment, "choosePortal")
                                    .addToBackStack("choosePortal")
                                    .commit()
                            }
                        }
                        else{
                            Toast.makeText(context, "Ошибка входа", Toast.LENGTH_SHORT).show()
                        }

                    }
                }


            }

        }
    }

    private fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}
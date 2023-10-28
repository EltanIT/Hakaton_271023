package com.example.hakaton_271023.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ActivityMainBinding
import com.example.hakaton_271023.databinding.FragmentLoginBinding
import com.example.hakaton_271023.view.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, LoginFragment(), "login")
            .commit()
        setContentView(binding.root)
    }

}
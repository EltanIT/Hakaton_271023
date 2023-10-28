package com.example.hakaton_271023.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.databinding.FragmentAdminHomeBinding
import com.example.hakaton_271023.databinding.FragmentAdminProfileBinding
import com.example.hakaton_271023.databinding.FragmentLoginBinding


class AdminProfileFragment : Fragment() {

    private lateinit var binding: FragmentAdminProfileBinding

    private var checkPassword = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminProfileBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    private fun setting() {

    }



}
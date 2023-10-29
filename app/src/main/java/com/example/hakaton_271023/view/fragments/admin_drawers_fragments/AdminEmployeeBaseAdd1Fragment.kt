package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminEmployeeBaseAdd1Binding

class AdminEmployeeBaseAdd1Fragment : Fragment() {

    private lateinit var binding: FragmentAdminEmployeeBaseAdd1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminEmployeeBaseAdd1Binding.inflate(layoutInflater)
        binding.add.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.admin_home_fragment_container, AdminEmployeeBaseAdd2Fragment())
                .addToBackStack("add2")
                .commit()
        }
        return binding.root
    }

}
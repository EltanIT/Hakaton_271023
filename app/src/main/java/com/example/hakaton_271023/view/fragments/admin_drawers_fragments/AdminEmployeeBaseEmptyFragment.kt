package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminEmployeeBaseEmptyBinding

class AdminEmployeeBaseEmptyFragment : Fragment() {
    private lateinit var binding: FragmentAdminEmployeeBaseEmptyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminEmployeeBaseEmptyBinding.inflate(layoutInflater)
        binding.addBtn.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.admin_home_fragment_container, AdminEmployeeBaseAdd1Fragment())
                .addToBackStack("add1")
                .commit()
        }
        return binding.root
    }

}
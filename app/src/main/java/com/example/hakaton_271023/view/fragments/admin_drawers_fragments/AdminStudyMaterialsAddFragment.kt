package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminStudyMaterialsAddBinding

class AdminStudyMaterialsAddFragment : Fragment() {

    private lateinit var binding: FragmentAdminStudyMaterialsAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminStudyMaterialsAddBinding.inflate(layoutInflater)

        binding.save.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.admin_home_fragment_container, AdminStudyMaterialsFillsFragment())
                .commit()
        }

        return binding.root
    }

}
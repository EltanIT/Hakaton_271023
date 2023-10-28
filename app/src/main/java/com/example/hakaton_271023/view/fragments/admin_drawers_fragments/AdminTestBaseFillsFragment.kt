package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminTestBaseFillsBinding

class AdminTestBaseFillsFragment : Fragment() {

    private lateinit var binding: FragmentAdminTestBaseFillsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminTestBaseFillsBinding.inflate(layoutInflater)

        binding.addBtn.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.admin_home_fragment_container, AdminTestBaseAddFragment())
                .addToBackStack("testAdd")
                .commit()
        }
        return binding.root
    }
}
package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentCommonTestBaseEmptyBinding
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminEmployeeBaseAdd1Fragment

class CommonTestBaseEmptyFragment : Fragment() {

    private lateinit var binding: FragmentCommonTestBaseEmptyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonTestBaseEmptyBinding.inflate(layoutInflater)
        return binding.root
    }


}
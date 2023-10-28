package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminHomeBinding
import com.example.hakaton_271023.databinding.FragmentAdminOurCompanyBinding
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity


class AdminOurCompanyFragment : Fragment() {

    private lateinit var binding: FragmentAdminOurCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminOurCompanyBinding.inflate(layoutInflater)
        setting()

        return binding.root
    }

    private fun setting() {
//        (activity as AdminProfileSlideBarActivity).setSupportActionBar(binding.toolbar)
        (activity as AdminProfileSlideBarActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}
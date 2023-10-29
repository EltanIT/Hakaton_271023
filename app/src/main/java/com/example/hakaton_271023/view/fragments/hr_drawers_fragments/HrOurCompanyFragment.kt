package com.example.hakaton_271023.view.fragments.hr_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminHomeBinding
import com.example.hakaton_271023.databinding.FragmentAdminOurCompanyBinding
import com.example.hakaton_271023.databinding.FragmentHrOurCompanyBinding
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity


class HrOurCompanyFragment : Fragment() {

    private lateinit var binding: FragmentHrOurCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHrOurCompanyBinding.inflate(layoutInflater)

        return binding.root
    }




}
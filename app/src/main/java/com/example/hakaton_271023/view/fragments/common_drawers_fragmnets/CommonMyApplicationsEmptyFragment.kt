package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentCommonMyApplicationsEmptyBinding

class CommonMyApplicationsEmptyFragment : Fragment() {

    private lateinit var binding: FragmentCommonMyApplicationsEmptyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonMyApplicationsEmptyBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    private fun setting() {
        binding.addBtn.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_common_fragment_container, CommonMyApplicationAddFragment())
                .addToBackStack("myApplicationAdd")
                .commit()
        }
    }


}
package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.databinding.FragmentCommonStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.TestModel
import com.example.hakaton_271023.view.adapter.CommonStudyMaterialOneAdapter

class CommonStudyMaterialPassTestFragment : Fragment() {

private lateinit var binding: FragmentCommonStudyMaterialsBinding
    private lateinit var commonStudyMaterialOneFragment: CommonStudyMaterialOneAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonStudyMaterialsBinding.inflate(layoutInflater)

        setting()


        return binding.root
    }

    private fun setting() {
        var list: ArrayList<TestModel> = ArrayList()
        list.add(TestModel("", "", ArrayList<Map<*, *>>()))
        list.add(TestModel("", "", ArrayList<Map<*, *>>()))
        commonStudyMaterialOneFragment = CommonStudyMaterialOneAdapter(list)
        binding.rvStudyMat.adapter = commonStudyMaterialOneFragment
    }
}
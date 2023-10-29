package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.databinding.FragmentAdminStudyMaterialOneBinding
import com.example.hakaton_271023.domain.model.TestModel
import com.example.hakaton_271023.view.adapter.AdminStudyMaterialOneAdapter

class AdminStudyMaterialOneFragment : Fragment() {

    private lateinit var binding: FragmentAdminStudyMaterialOneBinding
    private val testList = ArrayList<TestModel>()
    private lateinit var adminStudyMaterialOneAdapter: AdminStudyMaterialOneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminStudyMaterialOneBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    private fun setting() {
        testList.add(TestModel("", "", ArrayList<Map<*, *>>()))
        testList.add(TestModel("", "", ArrayList<Map<*, *>>()))
        testList.add(TestModel("", "", ArrayList<Map<*, *>>()))

        adminStudyMaterialOneAdapter = AdminStudyMaterialOneAdapter(testList)

        binding.rvStudyMat.adapter = adminStudyMaterialOneAdapter

    }

}
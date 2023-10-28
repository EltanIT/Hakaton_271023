package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.databinding.FragmentCommonStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel
import com.example.hakaton_271023.view.adapter.AdminStudyMaterialsAdapter
import com.example.hakaton_271023.view.adapter.CommonStudyMaterialsAdapter

class CommonStudyMaterialsFragment : Fragment() {

private lateinit var binding: FragmentCommonStudyMaterialsBinding
    private var studyMaterialsAdapter: CommonStudyMaterialsAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonStudyMaterialsBinding.inflate(layoutInflater)

        setting()


        return binding.root
    }

    private fun setting() {
        var list: ArrayList<StudyMaterialsModel> = ArrayList()

        binding.rvStudyMat.adapter = AdminStudyMaterialsAdapter(list)
    }
}
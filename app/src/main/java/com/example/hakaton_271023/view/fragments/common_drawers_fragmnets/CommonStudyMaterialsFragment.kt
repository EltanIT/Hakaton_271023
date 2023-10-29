package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentCommonStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel
import com.example.hakaton_271023.view.adapter.AdminStudyMaterialsAdapter
import com.example.hakaton_271023.view.adapter.CommonStudyMaterialsAdapter
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminEmployeeBaseAdd2Fragment

class CommonStudyMaterialsFragment : Fragment() {

private lateinit var binding: FragmentCommonStudyMaterialsBinding
    private var studyMaterialsAdapter: CommonStudyMaterialsAdapter? = null
    private lateinit var studyMaterialsAdapterListener: StudyMaterialsAdapterListener

    interface StudyMaterialsAdapterListener{
        fun execute()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonStudyMaterialsBinding.inflate(layoutInflater)
        interfaceListeners()
        setting()


        return binding.root
    }

    private fun interfaceListeners() {
        studyMaterialsAdapterListener = object : StudyMaterialsAdapterListener {
            override fun execute() {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_common_fragment_container, CommonStudyMaterialOneFragment())
                    .addToBackStack("studyMaterialOne")
                    .commit()
            }
        }
    }

    private fun setting() {
        var list: ArrayList<StudyMaterialsModel> = ArrayList()
        list.add(StudyMaterialsModel("name", "description", "link"))
        list.add(StudyMaterialsModel("name", "description", "link"))
        studyMaterialsAdapter = CommonStudyMaterialsAdapter(list, studyMaterialsAdapterListener)
        binding.rvStudyMat.adapter = studyMaterialsAdapter

    }
}
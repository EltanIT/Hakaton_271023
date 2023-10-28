package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminStudyMaterialsFillsBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel
import com.example.hakaton_271023.view.adapter.StudyMaterialsAdapter
import com.example.hakaton_271023.view.fragments.AdminHomeFragment

class AdminStudyMaterialsFillsFragment : Fragment() {

private lateinit var binding: FragmentAdminStudyMaterialsFillsBinding
    private var studyMaterialsAdapter: StudyMaterialsAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminStudyMaterialsFillsBinding.inflate(layoutInflater)

        setting()


        return binding.root
    }

    private fun setting() {
        var list: ArrayList<StudyMaterialsModel> = ArrayList()

//        if (list.size == 0
//        ){
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.admin_home_fragment_container, AdminStudyMaterialFragment())
//                .commit()
//        }

        binding.add.setOnClickListener{
            val fragment = requireActivity().supportFragmentManager.findFragmentByTag("home") as AdminHomeFragment

            fragment.selectFragment(AdminStudyMaterialsAddFragment())
        }
        binding.rvStudyMat.adapter = StudyMaterialsAdapter(list)
    }
}
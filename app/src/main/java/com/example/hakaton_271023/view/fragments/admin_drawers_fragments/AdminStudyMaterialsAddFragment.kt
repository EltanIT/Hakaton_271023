package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminStudyMaterialsAddBinding
import com.example.hakaton_271023.domain.model.StudyMaterialsModel

class AdminStudyMaterialsAddFragment : Fragment() {

    private lateinit var binding: FragmentAdminStudyMaterialsAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminStudyMaterialsAddBinding.inflate(layoutInflater)

        binding.save.setOnClickListener{

            if (binding.name.text?.isEmpty() == false && binding.description.text?.isEmpty() == false && binding.link.text?.isEmpty() == false){

                val studyMaterialsModel = StudyMaterialsModel(binding.name.text.toString(), binding.description.text.toString(), binding.link.text.toString())

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.admin_home_fragment_container, AdminStudyMaterialsFillsFragment())
                    .commit()
            }
            else{
                Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }


        }

        return binding.root
    }

}
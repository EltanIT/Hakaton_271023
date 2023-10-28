package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminStudyMaterialsAddBinding
import com.example.hakaton_271023.databinding.FragmentAdminTestBaseAddBinding
import com.example.hakaton_271023.domain.model.TestModel
import com.example.hakaton_271023.view.adapter.TestBaseAdapter

class AdminTestBaseAddFragment : Fragment() {

    private lateinit var binding: FragmentAdminTestBaseAddBinding
    private lateinit var adapter: TestBaseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminTestBaseAddBinding.inflate(layoutInflater)

        binding.add.setOnClickListener{

        }

        setting()

        return binding.root
    }

    private fun setting() {
        val list = ArrayList<TestModel>()
        list.add(TestModel())
        adapter = TestBaseAdapter(list)

        binding.rvTests.adapter = adapter

        binding.add.setOnClickListener{
            adapter.addItem(TestModel())
        }
    }

}
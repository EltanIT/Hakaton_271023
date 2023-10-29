package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.databinding.FragmentCommonStudyMaterialsBinding
import com.example.hakaton_271023.domain.model.TestModel
import com.example.hakaton_271023.domain.usecase.GetAllTestUserCase
import com.example.hakaton_271023.view.adapter.CommonStudyMaterialOneAdapter
import com.example.hakaton_271023.view.adapter.CommonStudyMaterialsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CommonStudyMaterialOneFragment : Fragment() {

private lateinit var binding: FragmentCommonStudyMaterialsBinding
    private var studyMaterialsAdapter: CommonStudyMaterialsAdapter? = null
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    var list: ArrayList<TestModel> = ArrayList()

    private val getAllTestUserCase = GetAllTestUserCase()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonStudyMaterialsBinding.inflate(layoutInflater)

        setting()

        return binding.root
    }

    override fun onResume() {
        coroutineScope.launch {
            val result = getAllTestUserCase.execute(requireContext())
            withContext(Dispatchers.Main){
                list.add(result)
            }
        }

        super.onResume()
    }

    private fun setting() {


        list.add(TestModel("", "", ArrayList<Map<*, *>>()))
        list.add(TestModel("", "", ArrayList<Map<*, *>>()))
        list.add(TestModel("", "", ArrayList<Map<*, *>>()))

        binding.rvStudyMat.adapter = CommonStudyMaterialOneAdapter(list)
    }
}
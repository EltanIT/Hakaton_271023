package com.example.hakaton_271023.view.fragments.common_drawers_fragmnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentCommonOurCompanyBinding
import com.example.hakaton_271023.domain.usecase.GetPortalByIdUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CommonOurCompanyFragment : Fragment() {

    private lateinit var binding: FragmentCommonOurCompanyBinding
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val getPortalByIdUseCase = GetPortalByIdUseCase()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonOurCompanyBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    override fun onResume() {
        coroutineScope.launch {
            val result = getPortalByIdUseCase.execute(requireContext())
            withContext(Dispatchers.Main){
                Toast.makeText(context, "$result", Toast.LENGTH_SHORT).show()
            }
        }
        super.onResume()
    }
    private fun setting() {

    }
}
package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.databinding.FragmentAdminOurCompanyBinding
import com.example.hakaton_271023.domain.usecase.GetPortalByIdUseCase
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AdminOurCompanyFragment : Fragment() {

    private lateinit var binding: FragmentAdminOurCompanyBinding
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val portalsInfoUseCase = GetPortalByIdUseCase()
    private lateinit var token: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminOurCompanyBinding.inflate(layoutInflater)
        setting()

        return binding.root
    }

    override fun onResume() {
        coroutineScope.launch {
            val companyModel = portalsInfoUseCase.execute(requireContext())
            withContext(Dispatchers.Main){
                if (companyModel != null){
                    binding.mission.setText(companyModel.mission)
                    binding.tel.setText(companyModel.phone_number)
                    binding.address.setText(companyModel.address)
                    binding.inn.setText(companyModel.inn)
//                    binding.color.setBackgroundColor(resources.getColor(R.color.))
                    binding.description.setText(companyModel.description)
                }

            }
        }
        super.onResume()
    }
    private fun setting() {
//        (activity as AdminProfileSlideBarActivity).setSupportActionBar(binding.toolbar)
        (activity as AdminProfileSlideBarActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}
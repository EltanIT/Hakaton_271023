package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminMyApplicationBinding
import com.example.hakaton_271023.domain.model.RequestModel
import com.example.hakaton_271023.view.adapter.AdminRequestAdapter

class AdminMyApplicationFragment : Fragment() {

    private lateinit var binding: FragmentAdminMyApplicationBinding
    private val requestList = ArrayList<RequestModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminMyApplicationBinding.inflate(layoutInflater)
        setting()
        return binding.root
    }

    private fun setting() {
        requestList.add(RequestModel("name", true))
        requestList.add(RequestModel("name", false))
        requestList.add(RequestModel("name", true))

        binding.rvRequest.adapter = AdminRequestAdapter(requestList)
    }


}
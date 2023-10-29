package com.example.hakaton_271023.view.fragments.admin_drawers_fragments

import android.R.attr.label
import android.R.attr.text
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminEmployeeBaseAdd2Binding


class AdminEmployeeBaseAdd2Fragment : Fragment() {

    private lateinit var binding: FragmentAdminEmployeeBaseAdd2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminEmployeeBaseAdd2Binding.inflate(layoutInflater)
        binding.copyLogin.setOnClickListener{
//            val clipboard: ClipboardManager? = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
//            val clip = ClipData.newPlainText(label.toString(), text.toString())
//            clipboard?.setPrimaryClip(clip)
        }
        return binding.root
    }



}
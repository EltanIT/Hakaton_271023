package com.example.hakaton_271023.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentChoosePortalBinding
import com.example.hakaton_271023.domain.model.PortalModel
import com.example.hakaton_271023.domain.usecase.GetAllPortalsUseCase
import com.example.hakaton_271023.domain.usecase.GetMyPortalsUseCase
import com.example.hakaton_271023.domain.usecase.SavePortalLocalUseCase
import com.example.hakaton_271023.view.activities.CommonSlideBarActivity
import com.example.hakaton_271023.view.adapter.ChoosePortalAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ChoosePortalFragment : Fragment() {

    private lateinit var binding: FragmentChoosePortalBinding
    private val getMyPortalsUseCase = GetMyPortalsUseCase()
    private val getAllPortalUseCase = GetAllPortalsUseCase()
    private val savePortalLocalUseCase = SavePortalLocalUseCase()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private lateinit var token: String
    private lateinit var role: String
    private var portalsList: ArrayList<PortalModel>? = ArrayList()

    private var selectPortal: PortalModel = PortalModel("", "", "", "", "", "", "", "", "", "", "")


    interface ChoosePortalAdapterListener{
        fun execute(portal: PortalModel)
    }

    private lateinit var choosePortalAdapterListener: ChoosePortalAdapterListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoosePortalBinding.inflate(layoutInflater)
        val bundle = arguments
        if (bundle!= null){
            role = bundle.getString("role", null)
        }
        setting()
        return binding.root
    }

    override fun onResume() {
        openView()
        coroutineScope.launch {
            portalsList = getAllPortalUseCase.execute(requireContext())
            withContext(Dispatchers.Main){
                if (portalsList != null){
                    binding.rvPortals.adapter = ChoosePortalAdapter(portalsList!!, choosePortalAdapterListener)
                }
                else{
                    Toast.makeText(context, "Ошибка при получении данных", Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onResume()
    }

    private fun setting() {
        choosePortalAdapterListener = object : ChoosePortalAdapterListener{
            override fun execute(portal: PortalModel) {
                selectPortal = portal
            }

        }

        binding.closeView.setOnClickListener{
            closeView()
        }
        binding.close.setOnClickListener{
            closeView()
        }

        binding.continueBtn.setOnClickListener{
                Log.i("seelctPortal", selectPortal.id)
                savePortalLocalUseCase.execute(selectPortal.id, requireContext())
                startActivity(Intent(requireContext(), CommonSlideBarActivity::class.java))
        }
    }

    fun openView(){
        val animation = AnimationUtils.loadAnimation(context, R.anim.choose_portal_open_anim)
        binding.openningView.startAnimation(animation)
    }
    fun closeView(){
        val animation = AnimationUtils.loadAnimation(context, R.anim.choose_portal_close_anim)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                requireActivity().supportFragmentManager.popBackStack()
            }
        })
        binding.openningView.startAnimation(animation)
    }

}
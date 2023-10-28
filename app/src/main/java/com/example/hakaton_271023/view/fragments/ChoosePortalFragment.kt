package com.example.hakaton_271023.view.fragments

import android.animation.Animator.AnimatorListener
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentChoosePortalBinding
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity


class ChoosePortalFragment : Fragment() {

    private lateinit var binding: FragmentChoosePortalBinding

    private var checkPassword = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoosePortalBinding.inflate(layoutInflater)
        setting()
//        openView()
        return binding.root
    }

    override fun onResume() {
        openView()
        super.onResume()
    }

    private fun setting() {
        binding.closeView.setOnClickListener{
            closeView()
        }
        binding.close.setOnClickListener{
            closeView()
        }

        binding.continueBtn.setOnClickListener{
            startActivity(Intent(requireContext(), AdminProfileSlideBarActivity::class.java))
        }

        binding.portal1.setOnClickListener{
            binding.portal1.isSelected = true
            binding.portal2.isSelected = false
            binding.portal3.isSelected = false
        }
        binding.portal2.setOnClickListener{
            binding.portal2.isSelected = true
            binding.portal1.isSelected = false
            binding.portal3.isSelected = false
        }
        binding.portal3.setOnClickListener{
            binding.portal3.isSelected = true
            binding.portal1.isSelected = false
            binding.portal2.isSelected = false
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
package com.example.hakaton_271023.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminHomeBinding
import com.example.hakaton_271023.databinding.FragmentLoginBinding
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminMyApplicationFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminOurCompanyFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminStudyMaterialFragment
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView


class AdminHomeFragment : Fragment() {

    private lateinit var binding: FragmentAdminHomeBinding

    private val adminOurCompanyFragment: Fragment = AdminOurCompanyFragment()
    private val adminMyApplicationFragment: Fragment = AdminMyApplicationFragment()
    private val adminStudyMaterialFragment: Fragment = AdminStudyMaterialFragment()

    private var activeFragment = adminOurCompanyFragment

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminHomeBinding.inflate(layoutInflater)
        setting()
        settingFragments()
        selectFragment(adminOurCompanyFragment)
        settingDrawer()
        return binding.root
    }

    private fun setting() {
        binding.adminNavView.setNavigationItemSelectedListener(object:
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.our_company ->{
                        selectFragment(adminOurCompanyFragment)
                        activeFragment = adminOurCompanyFragment
                        return true
                    }
                    R.id.my_requests ->{
                        selectFragment(adminMyApplicationFragment)
                        activeFragment = adminMyApplicationFragment
                        return true
                    }
                    R.id.my_study ->{
                        selectFragment(adminStudyMaterialFragment)
                        activeFragment = adminStudyMaterialFragment
                        return true
                    }
                }
                return false
            }

        })
    }

    fun settingDrawer(){
        (activity as AdminProfileSlideBarActivity).setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(requireActivity(),binding.adminDrawer,binding.toolbar,R.string.open_admin_slide_bar_txt,R.string.close_admin_slide_bar_txt)
        binding.adminDrawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun settingFragments() {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction
            .add(R.id.admin_home_fragment_container, adminMyApplicationFragment, "myApplication").hide(adminMyApplicationFragment)
            .add(R.id.admin_home_fragment_container, adminStudyMaterialFragment, "studyMaterial").hide(adminStudyMaterialFragment)
            .add(R.id.admin_home_fragment_container, adminOurCompanyFragment, "ourCompany").hide(adminOurCompanyFragment)
            .commit()
    }

    private fun selectFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
    }



}
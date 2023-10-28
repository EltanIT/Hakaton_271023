package com.example.hakaton_271023.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.FragmentAdminHomeBinding
import com.example.hakaton_271023.view.activities.AdminProfileSlideBarActivity
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminMyApplicationFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminOurCompanyFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminStudyMaterialFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminStudyMaterialsAddFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminStudyMaterialsFillsFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminTestBaseEmptyFragment
import com.example.hakaton_271023.view.fragments.admin_drawers_fragments.AdminTestBaseFillsFragment
import com.google.android.material.navigation.NavigationView


class AdminHomeFragment : Fragment() {

    private lateinit var binding: FragmentAdminHomeBinding

    private val adminOurCompanyFragment: Fragment = AdminOurCompanyFragment()
    private val adminMyApplicationFragment: Fragment = AdminMyApplicationFragment()
    private val adminStudyMaterialFillsFragment: Fragment = AdminStudyMaterialsFillsFragment()
    private val adminTestBaseFillsFragment: Fragment = AdminTestBaseFillsFragment()

    private var activeFragment = adminOurCompanyFragment

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminHomeBinding.inflate(layoutInflater)
        settingDrawer()
        setting()
//        settingFragments()
        selectFragment(adminOurCompanyFragment)
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
                        closeDrawerView()
                        return true
                    }
                    R.id.my_requests ->{
                        selectFragment(adminMyApplicationFragment)
                        activeFragment = adminMyApplicationFragment
                        closeDrawerView()
                        return true
                    }
                    R.id.base_material ->{
                        selectFragment(adminStudyMaterialFillsFragment)
                        activeFragment = adminStudyMaterialFillsFragment
                        closeDrawerView()
                        return true
                    }
                    R.id.base_tests ->{
                        selectFragment(adminTestBaseFillsFragment)
                        activeFragment = adminTestBaseFillsFragment
                        closeDrawerView()
                        return true
                    }
                }
                return false
            }

        })

    }

    fun closeDrawerView(){
        if (binding.adminDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.adminDrawer.closeDrawer(GravityCompat.START)
        }
    }

    fun settingDrawer(){
        (activity as AdminProfileSlideBarActivity).setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(requireActivity(),binding.adminDrawer,binding.toolbar,R.string.open_admin_slide_bar_txt,R.string.close_admin_slide_bar_txt)
        binding.adminDrawer.addDrawerListener(toggle)
        binding.adminDrawer.bringToFront()
        binding.adminDrawer.requestLayout()
        toggle.syncState()
    }

//    private fun settingFragments() {
//        val transaction = requireActivity().supportFragmentManager.beginTransaction()
//        transaction
//            .add(R.id.admin_home_fragment_container, adminMyApplicationFragment, "myApplication").hide(adminMyApplicationFragment)
//            .add(R.id.admin_home_fragment_container, adminTestBaseEmptyFragment, "testBaseEmpty").hide(adminTestBaseEmptyFragment)
//            .add(R.id.admin_home_fragment_container, adminTestBaseFillsFragment, "testBaseFills").hide(adminTestBaseFillsFragment)
//            .add(R.id.admin_home_fragment_container, adminStudyMaterialFragment, "studyMaterial").hide(adminStudyMaterialFragment)
//            .add(R.id.admin_home_fragment_container, adminStudyMaterialFillsFragment, "studyMaterialFills").hide(adminStudyMaterialFillsFragment)
//            .add(R.id.admin_home_fragment_container, adminStudyMaterialAddFragment, "studyMaterialAdd").hide(adminStudyMaterialAddFragment)
//            .add(R.id.admin_home_fragment_container, adminOurCompanyFragment, "ourCompany").hide(adminOurCompanyFragment)
//            .commit()
//    }

    fun selectFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.admin_home_fragment_container, fragment)
            .commit()
    }



}
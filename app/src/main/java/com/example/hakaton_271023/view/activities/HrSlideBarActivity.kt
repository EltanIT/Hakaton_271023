package com.example.hakaton_271023.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ActivityHrSlideBarBinding
import com.example.hakaton_271023.view.fragments.StructureFragment
import com.example.hakaton_271023.view.fragments.hr_drawers_fragments.HrOurCompanyFragment
import com.google.android.material.navigation.NavigationView

class HrSlideBarActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHrSlideBarBinding

    private val hrOurCompanyFragment = HrOurCompanyFragment()
    private val structureFragment = StructureFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHrSlideBarBinding.inflate(layoutInflater)
        setting()
        selectFragment(hrOurCompanyFragment)
        setContentView(binding.root)
    }

    private fun setting() {
        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,R.string.open_admin_slide_bar_txt,R.string.close_admin_slide_bar_txt)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
        binding.hrNavView.setNavigationItemSelectedListener(object:
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.our_company_hr ->{
                        selectFragment(hrOurCompanyFragment)
                        closeDrawerView()
                        return true
                    }
                    R.id.structure_hr ->{
                        selectFragment(structureFragment)
                        closeDrawerView()
                        return true
                    }
                }
                return false
            }

        })



    }

    fun closeDrawerView(){
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }

    }

    private fun selectFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_hr_fragment_container, fragment)
            .commit()
    }
}
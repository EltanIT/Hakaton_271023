package com.example.hakaton_271023.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ActivityAdminProfileSlideBarBinding
import com.example.hakaton_271023.databinding.ActivityCommonSlideBarBinding
import com.google.android.material.navigation.NavigationView

class CommonSlideBarActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityCommonSlideBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommonSlideBarBinding.inflate(layoutInflater)
        settting()
        setContentView(binding.root)
    }

    private fun settting() {
        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,R.string.open_admin_slide_bar_txt,R.string.close_admin_slide_bar_txt)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

        binding.adminNavView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}



package com.example.hakaton_271023.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hakaton_271023.R
import com.example.hakaton_271023.databinding.ActivityAdminProfileSlideBarBinding
import com.example.hakaton_271023.view.fragments.AdminHomeFragment


class AdminProfileSlideBarActivity : AppCompatActivity(){
    private lateinit var binding: ActivityAdminProfileSlideBarBinding

    private val adminHomeFragment: Fragment = AdminHomeFragment()
    private var activeFragment: Fragment = adminHomeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminProfileSlideBarBinding.inflate(layoutInflater)
        setting()
        settingFragments()
        selectFragment(activeFragment)
        setContentView(binding.root)
    }

    private fun setting() {
        binding.adminFragmentContainer.bringToFront()
    }


    private fun settingFragments() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.admin_fragment_container, adminHomeFragment, "home")?.hide(adminHomeFragment)
                    ?.commit()
    }

    private fun selectFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
    }


}






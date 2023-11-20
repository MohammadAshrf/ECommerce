package com.example.ecommerce.ui.home

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ActivityHomeBinding
import com.example.ecommerce.ui.home.tabs.categories.CategoriesFragment
import com.example.ecommerce.ui.home.tabs.home.HomeFragment
import com.example.ecommerce.ui.home.tabs.profile.ProfileFragment
import com.example.ecommerce.ui.home.tabs.wishList.WishListFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        viewBinding.bottomNav.itemIconTintList = null

        viewBinding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    showTabFragment(HomeFragment())
                }

                R.id.nav_categories -> {
                    showTabFragment(CategoriesFragment())
                }

                R.id.nav_wish_list -> {
                    showTabFragment(WishListFragment())
                }

                R.id.nav_profile -> {
                    showTabFragment(ProfileFragment())
                }
            }
            true
        }

        viewBinding.bottomNav.selectedItemId = R.id.nav_home
    }

    private fun showTabFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
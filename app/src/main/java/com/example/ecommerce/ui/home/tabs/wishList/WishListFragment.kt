package com.example.ecommerce.ui.home.tabs.wishList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerce.databinding.FragmentWishListBinding

class WishListFragment : Fragment() {
    private lateinit var viewBinding: FragmentWishListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
 viewBinding= FragmentWishListBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}
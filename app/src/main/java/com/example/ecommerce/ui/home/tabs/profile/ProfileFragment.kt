package com.example.ecommerce.ui.home.tabs.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerce.databinding.FragmentHomeBinding
import com.example.ecommerce.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var viewBinding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
 viewBinding= FragmentProfileBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}
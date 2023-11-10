package com.example.ecommerce.ui.home.tabs.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerce.databinding.FragmentCategoriesBinding
import com.example.ecommerce.databinding.FragmentHomeBinding

class CategoriesFragment : Fragment() {
    private lateinit var viewBinding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
 viewBinding= FragmentCategoriesBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}
package com.example.ecommerce.ui.home.tabs.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.entity.category.Data
import com.example.ecommerce.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    // on below line we are creating a variable for our array list for storing our images.
    private lateinit var imageUrl: List<Data>

    // on below line we are creating a variable for our slider view.
    private lateinit var sliderView: SliderView

    // on below line we are creating a variable for our slider adapter.
    private lateinit var sliderAdapter: HomeSliderAdapter

    private lateinit var item: Data

    private val homeCategoryViewModel: HomeCategoryViewModel by viewModels()
    private val homeApplianceViewModel: HomeApplianceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)

        // on below line we are initializing our slier view.
        sliderView = viewBinding.sliderHomeImage

        // on below line we are initializing
        // our image url array list.
        imageUrl = listOf()


        // on below line we are adding data to our image url array list.
//        imageUrl =
//            ((imageUrl + Glide.with(viewBinding.root.context).load(item.image).into(viewBinding.sliderHomeImage)).toString())
//        imageUrl =
//            (imageUrl + "https://i.ibb.co/H2QJKrM/dewGXctU.jpg")
//        imageUrl =
//            (imageUrl + "https://i.ibb.co/TBcsPth/yrnp7GBp.jpg")

        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = HomeSliderAdapter(imageUrl)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        sliderView.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        sliderView.scrollTimeInSec = 3

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        sliderView.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()


        homeCategoryViewModel.getCategories()
        homeApplianceViewModel.getAppliance()
        val homeCategoryAdapter = HomeCategoryGridAdapter()
        val homeAppGridAdapter = HomeAppGridAdapter()
        lifecycleScope.launch {
            launch {
                homeCategoryViewModel.categories.collect {
                    Log.e("TAG", "onCreateView: $it")
                    homeCategoryAdapter.submitList(it?.data)
                }
            }
            launch {
                homeApplianceViewModel.appliance.collect {
                    Log.e("TAG123", "onCreateView123: $it")
                    homeAppGridAdapter.submitList(it?.data)
                }
            }
        }

        viewBinding.rvHomeAppliance.adapter = homeAppGridAdapter
        viewBinding.rvCategories.adapter = homeCategoryAdapter
        return viewBinding.root
    }
}
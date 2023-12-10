package com.example.ecommerce.ui.home.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView


class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    // on below line we are creating a variable for our array list for storing our images.
    private lateinit var imageUrl: List<String>

    // on below line we are creating a variable for our slider view.
    private lateinit var sliderView: SliderView

    // on below line we are creating a variable for our slider adapter.
    private lateinit var sliderAdapter: HomeSliderAdapter

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
        imageUrl = ArrayList()

        // on below line we are adding data to our image url array list.
        imageUrl =
            (imageUrl + "https://i.ibb.co/gFpXYXz/8qd1CHFq.png")
        imageUrl =
            (imageUrl + "https://i.ibb.co/H2QJKrM/dewGXctU.jpg")
        imageUrl =
            (imageUrl + "https://i.ibb.co/TBcsPth/yrnp7GBp.jpg")

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


        val categoryItems = listOf(
            GridItem(R.drawable.men, "Item 1"),
            GridItem(R.drawable.men, "Item 2"),
            GridItem(R.drawable.men, "Item 3"),
            GridItem(R.drawable.men, "Item 5"),
            GridItem(R.drawable.men, "Item 6"),
            GridItem(R.drawable.men, "Item 7"),
            GridItem(R.drawable.men, "Item 8"),
            GridItem(R.drawable.men, "Item 9"),
            GridItem(R.drawable.men, "Item 10"),
            GridItem(R.drawable.men, "Item 11"),
            GridItem(R.drawable.men, "Item 12"),
            GridItem(R.drawable.men, "Item 13"),
            // Add more items as needed
        )

        val categoryAdapter = CategoryGridAdapter(categoryItems)
        viewBinding.rvCategories.adapter = categoryAdapter

        val homeAppItems = listOf(
            GridItem(R.drawable.washer, "Item 1"),
            GridItem(R.drawable.washer, "Item 2"),
            GridItem(R.drawable.washer, "Item 3"),
            GridItem(R.drawable.washer, "Item 5"),
            GridItem(R.drawable.washer, "Item 6"),
            GridItem(R.drawable.washer, "Item 7"),
            GridItem(R.drawable.washer, "Item 8"),
            GridItem(R.drawable.washer, "Item 9"),
            GridItem(R.drawable.washer, "Item 10"),
            GridItem(R.drawable.washer, "Item 11"),
            GridItem(R.drawable.washer, "Item 12"),
            GridItem(R.drawable.washer, "Item 13"),

            // Add more items as needed
        )

        val homeAppAdapter = HomeAppGridAdapter(homeAppItems)
        viewBinding.rvHomeAppliance.adapter = homeAppAdapter


        return viewBinding.root
    }
}
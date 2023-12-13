package com.example.ecommerce.ui.home.tabs.categories.products

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.databinding.ActivityProductDetailBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityProductDetailBinding

    // on below line we are creating a variable for our array list for storing our images.
    private lateinit var imageUrl: List<String>

    // on below line we are creating a variable for our slider view.
    private lateinit var sliderView: SliderView

    // on below line we are creating a variable for our slider adapter.
    private lateinit var sliderAdapter: ProductDetailSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // on below line we are initializing our slier view.
        sliderView = viewBinding.sliderProductDetailImage

        // on below line we are initializing
        // our image url array list.
        imageUrl = ArrayList()

        // on below line we are adding data to our image url array list.
        imageUrl =
            (imageUrl + "https://i.ibb.co/h8Fznh6/product-image.png")
        imageUrl =
            (imageUrl + "https://i.ibb.co/H2QJKrM/dewGXctU.jpg")
        imageUrl =
            (imageUrl + "https://i.ibb.co/TBcsPth/yrnp7GBp.jpg")

        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = ProductDetailSliderAdapter(imageUrl)

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

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM) //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        sliderView.indicatorSelectedColor = Color.WHITE
        sliderView.indicatorUnselectedColor = Color.GRAY

        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()

    }
}
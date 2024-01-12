package com.example.ecommerce.ui.home.tabs.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.ecommerce.databinding.FragmentHomeBinding
import com.example.ecommerce.databinding.ItemCategoriesGridBinding
import com.example.ecommerce.ui.home.tabs.home.category.HomeCategoryGridAdapter
import com.example.ecommerce.ui.home.tabs.home.category.HomeCategoryViewModel
import com.example.ecommerce.ui.home.tabs.home.electronics.ElectronicsGridAdapter
import com.example.ecommerce.ui.home.tabs.home.electronics.ElectronicsViewModel
import com.example.ecommerce.ui.home.tabs.home.men.MensGridAdapter
import com.example.ecommerce.ui.home.tabs.home.men.MensViewModel
import com.example.ecommerce.ui.home.tabs.home.woman.WomanShawlGridAdapter
import com.example.ecommerce.ui.home.tabs.home.woman.WomanShawlViewModel
import com.facebook.shimmer.ShimmerFrameLayout
import com.smarteist.autoimageslider.SliderView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _viewBinding: FragmentHomeBinding? = null
    private lateinit var homeCategoryViewModel: HomeCategoryViewModel
    private lateinit var homeWomanShawlViewModel: WomanShawlViewModel
    private lateinit var homeMensViewModel: MensViewModel
    private lateinit var homeElectronicsViewModel: ElectronicsViewModel

    private lateinit var catBinding: ItemCategoriesGridBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeCategoryViewModel = ViewModelProvider(this)[HomeCategoryViewModel::class.java]
        homeWomanShawlViewModel = ViewModelProvider(this)[WomanShawlViewModel::class.java]
        homeMensViewModel = ViewModelProvider(this)[MensViewModel::class.java]
        homeElectronicsViewModel = ViewModelProvider(this)[ElectronicsViewModel::class.java]
    }

    private val binding get() = _viewBinding!!

    private lateinit var shimmerCategories: ShimmerFrameLayout
    private lateinit var shimmerWoman: ShimmerFrameLayout


    // on below line we are creating a variable for our array list for storing our images.
    private lateinit var imageUrl: List<String>

    // on below line we are creating a variable for our slider view.
    private lateinit var sliderView: SliderView

    // on below line we are creating a variable for our slider adapter.
    private lateinit var sliderAdapter: HomeSliderAdapter


//    private val homeCategoryViewModel: HomeCategoryViewModel by viewModels()
//    private val homeWomanShawlViewModel: WomanShawlViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        catBinding = ItemCategoriesGridBinding.inflate(inflater, container, false)

        //shimmer
//        shimmerSlider = viewBinding.shimmerSliderLayout
        shimmerCategories = catBinding.shimmerCategoriesLayout
        shimmerWoman = binding.shimmerWomanLayout

        // Initially start the shimmer effect
//        shimmerSlider.startShimmer()
        shimmerCategories.startShimmer()
        shimmerWoman.startShimmer()

        // on below line we are initializing our slier view.
        sliderView = binding.sliderHomeImage

        // on below line we are initializing
        // our image url array list.
        imageUrl = ArrayList()


        //  on below line we are adding data to our image url array list.
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


        val homeCategoryAdapter = HomeCategoryGridAdapter()
        val homeWomanShawlGridAdapter = WomanShawlGridAdapter()
        val homeTShirtsGridAdapter = MensGridAdapter()
        val homeElectronicsGridAdapter = ElectronicsGridAdapter()
        binding.rvWomanShawl.adapter = homeWomanShawlGridAdapter
        binding.rvCategories.adapter = homeCategoryAdapter
        binding.rvMens.adapter = homeTShirtsGridAdapter
        binding.rvElectronics.adapter = homeElectronicsGridAdapter

        //categories
        lifecycleScope.launch {
            launch {
                homeCategoryViewModel.homeCategories.collect {
                    Log.e("TAG", "onCreateView: $it")
                    homeCategoryAdapter.submitList(it)
//                    shimmerCategories.stopShimmer()
//                    shimmerCategories.visibility = View.GONE
                }
            }
            //Woman Shawl
            launch {
                homeWomanShawlViewModel.womanShawlProducts.collect {
                    Log.e("TAG123", "onCreateView123: $it")
                    homeWomanShawlGridAdapter.submitList(it)
//                    shimmerCategories.stopShimmer()
//                    shimmerCategories.visibility = View.GONE
                }
            }

            //Mens
            launch {
                homeMensViewModel.mensProducts.collect { mensProducts ->
                    Log.e("TAG1234", "onCreateView1234: $mensProducts")
                    homeTShirtsGridAdapter.submitList(mensProducts)
                }
            }

            //Electronics
            launch {
                homeElectronicsViewModel.electronicProducts.collect { electronicProducts ->
                    Log.e("TAG12345", "onCreateView12345: $electronicProducts")
                    homeElectronicsGridAdapter.submitList(electronicProducts)
                }
            }
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeCategoryViewModel.getHomeCategories()
        homeWomanShawlViewModel.getWomanShawlProducts()
        homeMensViewModel.getMensProducts()
        homeElectronicsViewModel.getElectronicProducts()
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}
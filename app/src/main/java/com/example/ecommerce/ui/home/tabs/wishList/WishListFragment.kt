package com.example.ecommerce.ui.home.tabs.wishList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentWishListBinding

class WishListFragment : Fragment() {
    private lateinit var viewBinding: FragmentWishListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentWishListBinding.inflate(inflater, container, false)

        val wishListItems = listOf(
            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),

            WishListItem(
                R.drawable.product_wish_list, "GUESS Women's",
                R.drawable.ic_wish_listed, R.drawable.icon_product_color, "Gold Watch",
                "EGP 1.200", "EGP 1.500"
            ),


            )

        val wishListAdapter = WishListAdapter(wishListItems)
        viewBinding.rvWishList.adapter = wishListAdapter




        return viewBinding.root
    }
}
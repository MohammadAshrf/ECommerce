package com.example.ecommerce.ui.home.tabs.categories.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val cartItems = listOf(
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
            CartItem(
                R.drawable.product_img, "Nike Air Jordan"
            ),
        )

        val cartListAdapter = CartListAdapter(cartItems)
        viewBinding.rvCartList.adapter = cartListAdapter


    }
}
package com.example.ecommerce.ui.home.tabs.home.woman

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.product.model.Product
import com.example.domain.features.product.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WomanShawlViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val _womanShawlProduct: MutableStateFlow<List<Product?>?> =
        MutableStateFlow(emptyList())
    val womanShawlProducts: StateFlow<List<Product?>?> = _womanShawlProduct

    fun getWomanShawlProducts() {
        viewModelScope.launch {
            try {
                _womanShawlProduct.value = getProductsUseCase()?.filter {
                    it?.category?.name == "Women's Fashion"
                }
            } catch (e: Exception) {
                Log.e("WomanShawlViewModel", e.message.toString())
            }
        }
    }
}
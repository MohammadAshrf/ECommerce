package com.example.ecommerce.ui.home.tabs.home.men

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
class MensViewModel @Inject constructor(
    private val mensProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val _mensProducts: MutableStateFlow<List<Product?>?> = MutableStateFlow(emptyList())
    val mensProducts: StateFlow<List<Product?>?> = _mensProducts

    fun getMensProducts() {
        viewModelScope.launch {
            try {
                _mensProducts.value = mensProductsUseCase()?.filter {
                    it?.category?.name == "Men's Fashion"
                }

            } catch (e: Exception) {
                Log.e("MensViewModel", e.message.toString())
            }
        }
    }
}
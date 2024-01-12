package com.example.ecommerce.ui.home.tabs.home.electronics

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.electronicsProduct.model.ElectronicProducts
import com.example.domain.features.electronicsProduct.usecase.GetElectronicProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ElectronicsViewModel @Inject constructor(
    private val electronicProductsUseCase: GetElectronicProductsUseCase,
) : ViewModel() {

    private val _electronicProducts: MutableStateFlow<List<ElectronicProducts?>?> =
        MutableStateFlow(null)
    val electronicProducts: StateFlow<List<ElectronicProducts?>?> = _electronicProducts

    fun getElectronicProducts() {
        viewModelScope.launch {
            try {
                _electronicProducts.value = electronicProductsUseCase()?.filter {
                    it?.category?.name == "Electronics"
                }

            } catch (e: Exception) {
                Log.e("MensViewModel", e.message.toString())
            }
        }
    }
}
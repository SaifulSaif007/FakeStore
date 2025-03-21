package com.saiful.fakestore.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saiful.fakestore.data.model.product.ProductResponse
import com.saiful.fakestore.data.repository.RepositoryImpl
import com.saiful.fakestore.network.ApiService
import com.saiful.fakestore.network.ktorClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    val products = MutableStateFlow<List<ProductResponse>>(emptyList())

    private val repository = RepositoryImpl(
        ApiService(ktorClient)
    )

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            val result = repository.getProducts()

            if (result.isSuccess) {
                products.value = result.getOrDefault(emptyList())
            }
        }
    }
}
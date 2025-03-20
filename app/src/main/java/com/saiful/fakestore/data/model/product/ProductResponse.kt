package com.saiful.fakestore.data.model.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
)
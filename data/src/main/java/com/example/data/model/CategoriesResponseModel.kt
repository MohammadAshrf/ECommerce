package com.example.data.model


import com.google.gson.annotations.SerializedName

data class CategoriesResponseModel(
    @SerializedName("data")
    val `data`: List<Data>? = null,
    @SerializedName("metadata")
    val metadata: Metadata?,
    @SerializedName("results")
    val results: Int?
)
package com.example.data.model.product

import com.example.domain.features.category.model.Category
import com.example.domain.features.product.model.Product
import com.example.domain.features.subCategories.model.Brand
import com.example.domain.features.subCategories.model.SubCategory
import com.google.gson.annotations.SerializedName

data class ProductDto(

    @field:SerializedName("sold")
    val sold: Int? = null,

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @field:SerializedName("availableColors")
    val availableColors: List<Any?>? = null,

    @field:SerializedName("imageCover")
    val imageCover: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("ratingsQuantity")
    val ratingsQuantity: Int? = null,

    @field:SerializedName("ratingsAverage")
    val ratingsAverage: Double? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("subcategory")
    val subcategory: List<SubCategory?>? = null,

    @field:SerializedName("category")
    val category: Category? = null,

    @field:SerializedName("brand")
    val brand: Brand? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null,

    @field:SerializedName("priceAfterDiscount")
    val priceAfterDiscount: Int? = null
) {

    fun toProduct(): Product {
        return Product(
            sold, images, quantity, imageCover, description, title,
            ratingsQuantity, ratingsAverage, createdAt, price, id, subcategory,
            category, brand, slug, updatedAt
        )
    }
}
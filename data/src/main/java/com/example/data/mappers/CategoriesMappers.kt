package com.example.data.mappers

import com.example.data.model.CategoriesResponseModel
import com.example.data.model.Data
import com.example.data.model.Metadata
import com.example.domain.entity.category.CategoryResponse

fun CategoriesResponseModel.toEntity(): CategoryResponse {
    return CategoryResponse(data?.map { it.toEntity() }, metadata?.toEntity(), results)
}

fun Data.toEntity(): com.example.domain.entity.category.Data {
    return com.example.domain.entity.category.Data(id, createdAt, image, name, slug, updatedAt)
}

fun Metadata.toEntity(): com.example.domain.entity.category.Metadata {
    return com.example.domain.entity.category.Metadata(currentPage, limit, numberOfPages)
}
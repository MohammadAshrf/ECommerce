//package com.example.data.mappers
//
//import com.example.data.model.CategoriesResponseModel
//import com.example.data.model.SubCategory
//import com.example.data.model.category.Metadata
//import com.example.domain.entity.category.CategoryResponse
//
//fun CategoriesResponseModel.toEntity(): CategoryResponse {
//    return CategoryResponse(data?.map { it.toEntity() }, metadata?.toEntity(), results)
//}
//
//fun SubCategory.toEntity(): com.example.domain.entity.category.SubCategory {
//    return com.example.domain.entity.category.SubCategory(id, createdAt, image, name, slug, updatedAt)
//}
//
//fun Metadata.toEntity(): com.example.domain.entity.category.Metadata {
//    return com.example.domain.entity.category.Metadata(currentPage, limit, numberOfPages)
//}
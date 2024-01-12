package com.example.domain.features.category.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
	val image: String? = null,
	val createdAt: String? = null,
	val name: String? = null,
	var id: String? = null,
	val slug: String? = null,
	val updatedAt: String? = null
) : Parcelable

package com.github.joaolucasl.chumlee.products.domain

data class Product(
    val id: Int,
    val externalId: String,
    val price: Int,
    val title: String,
    val description: String
)
package com.github.joaolucasl.chumlee.products.domain

data class Product(
    val id: Int,
    val externalId: String,
    var price: Int,
    val title: String,
    val description: String
) {
    fun applyDiscount(percentage: Float) {
        price -= (price * percentage).toInt()
    }
}
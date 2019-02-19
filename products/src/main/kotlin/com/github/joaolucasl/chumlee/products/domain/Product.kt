package com.github.joaolucasl.chumlee.products.domain

data class Product(
    val id: Int,
    val externalId: String,
    var price: Int,
    val title: String,
    val description: String
) {
    fun applyDiscount(discount: Discount) {
        price -= (price * discount.percentage).toInt()
    }
}
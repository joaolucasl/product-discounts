package com.github.joaolucasl.chumlee.products.application.services

import com.github.joaolucasl.chumlee.products.domain.Discount
import com.github.joaolucasl.chumlee.products.domain.Product

interface DiscountCalculationService {
    fun getDiscounts(products: List<Product>, userId: String): List<Discount>?
    fun applyDiscountToProducts(products: List<Product>, discounts: List<Discount>): List<Product>
}
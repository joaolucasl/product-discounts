package com.github.joaolucasl.chumlee.products.application.services

import com.github.joaolucasl.chumlee.products.domain.Product

interface ProductsService {
    fun listProducts(): List<Product>
}
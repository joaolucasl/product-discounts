package com.github.joaolucasl.chumlee.products.application.services.impl

import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.domain.Product

class ProductsServiceImpl : ProductsService {
    override fun listProducts(): List<Product> {
        return listOf(
            Product(1, "PRD-AAAAAAAAAAAA", 30000, "iPhone", "BLABLABLA"),
            Product(2, "PRD-BBBBBBBBBBBB", 20000, "Xiaomi Mi 8", "BLABLABLA")
        )
    }
}
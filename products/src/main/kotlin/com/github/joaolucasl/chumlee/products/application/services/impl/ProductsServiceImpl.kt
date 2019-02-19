package com.github.joaolucasl.chumlee.products.application.services.impl

import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.domain.Product
import com.github.joaolucasl.chumlee.products.infrastructure.persistence.repository.ProductsRepository
import org.slf4j.LoggerFactory

class ProductsServiceImpl(
    private val repository: ProductsRepository
) : ProductsService {
    private val LOGGER = LoggerFactory.getLogger(javaClass)

    override fun listProducts(): List<Product> {
        LOGGER.info("Fetching product data")
        return repository.findAll()
    }
}
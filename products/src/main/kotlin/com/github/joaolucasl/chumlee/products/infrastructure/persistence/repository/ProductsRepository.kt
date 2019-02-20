package com.github.joaolucasl.chumlee.products.infrastructure.persistence.repository

import com.github.joaolucasl.chumlee.products.domain.Product
import com.github.joaolucasl.chumlee.products.infrastructure.persistence.mapper.ProductMapper
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper
import org.jdbi.v3.sqlobject.statement.SqlQuery

@RegisterBeanMapper(ProductMapper::class)
interface ProductsRepository {
    @SqlQuery("SELECT * FROM products ORDER BY id ASC")
    fun findAll(): List<Product>
}
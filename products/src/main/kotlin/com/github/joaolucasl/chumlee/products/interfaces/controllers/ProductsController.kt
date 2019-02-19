package com.github.joaolucasl.chumlee.products.interfaces.controllers

import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.infrastructure.transformers.JsonTransformer
import org.koin.spark.SparkController
import spark.Route
import spark.Spark.get
import spark.Spark.path

class ProductsController(
    private val productsService: ProductsService
) : SparkController {
    private val jsonTransformer = JsonTransformer()

    init {
        path("/products") {
            get("", "application/json", getProducts() , jsonTransformer)
        }
    }

    fun getProducts() = Route { _, response ->
        response.type("application/json")

        val products = productsService.listProducts()

        ProductsListDTO(products)
    }
}
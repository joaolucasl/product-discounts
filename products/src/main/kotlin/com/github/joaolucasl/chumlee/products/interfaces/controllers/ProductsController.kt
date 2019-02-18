package com.github.joaolucasl.chumlee.products.interfaces.controllers

import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.infrastructure.transformers.JsonTransformer
import org.koin.spark.SparkController
import spark.Route
import spark.Spark.path
import spark.Spark.get

class ProductsController(
    val productsService: ProductsService
) : SparkController {
    val jsonTransformer = JsonTransformer()

    init {
        path("/products") {
            get("/", Route { productsService.listProducts() }, jsonTransformer)
        }
    }
}
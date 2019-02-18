package com.github.joaolucasl.chumlee.products.interfaces.controllers

import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.infrastructure.transformers.JsonTransformer
import org.koin.spark.SparkController
import spark.Request
import spark.Response
import spark.Route
import spark.Spark.path
import spark.Spark.get

class ProductsController(
    val productsService: ProductsService
) : SparkController {
    val jsonTransformer = JsonTransformer()

    init {
        path("/products") {
            get("", "application/json", Route { _, _ ->
                ProductsListDTO(productsService.listProducts())
            }, jsonTransformer)
        }
    }
}
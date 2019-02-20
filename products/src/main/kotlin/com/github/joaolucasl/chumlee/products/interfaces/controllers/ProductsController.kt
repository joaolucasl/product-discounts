package com.github.joaolucasl.chumlee.products.interfaces.controllers

import com.github.joaolucasl.chumlee.products.application.services.DiscountCalculationService
import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.domain.Discount
import com.github.joaolucasl.chumlee.products.infrastructure.transformers.JsonTransformer
import org.koin.spark.SparkController
import org.slf4j.LoggerFactory
import spark.Route
import spark.Spark.get
import spark.Spark.path

class ProductsController(
    private val productsService: ProductsService,
    private val discountCalculationService: DiscountCalculationService
) : SparkController {
    private val LOGGER = LoggerFactory.getLogger(javaClass)
    private val jsonTransformer = JsonTransformer()

    init {
        path("/products") {
            get("", "application/json", getProducts() , jsonTransformer)
        }
    }

    fun getProducts() = Route { request , response ->
        response.type("application/json")

        val userId: String = request.headers("USER_ID") ?: return@Route ErrorResponse("Must have USER_ID header")

        val products = productsService.listProducts()

        try {
            val discounts = discountCalculationService.getDiscounts(products, userId)
            val discountedProducts = discountCalculationService.applyDiscountToProducts(products, discounts!!)

            return@Route ProductsListDTO(discountedProducts)
        } catch (e: Exception) {
            LOGGER.error("Failed while fetching discounts. Falling back to normal prices", e)
        }

        return@Route ProductsListDTO(products)
    }
}
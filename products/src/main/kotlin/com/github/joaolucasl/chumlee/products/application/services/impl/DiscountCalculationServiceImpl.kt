package com.github.joaolucasl.chumlee.products.application.services.impl

import com.github.joaolucasl.chumlee.products.application.services.DiscountCalculationService
import com.github.joaolucasl.chumlee.products.domain.Discount
import com.github.joaolucasl.chumlee.products.domain.Product
import com.github.joaolucasl.chumlee.products.infrastructure.DiscountsServerClient
import org.slf4j.LoggerFactory
import com.github.joaolucasl.chumlee.DiscountServiceOuterClass.Product as ProtoProduct

class DiscountCalculationServiceImpl(
    private val serverClient: DiscountsServerClient
) : DiscountCalculationService {
    private val LOGGER = LoggerFactory.getLogger(javaClass)

    override fun applyDiscountToProducts(products: List<Product>, discounts: List<Discount>): List<Product> {
        val discountsPerProduct = discounts.associateBy({ it.productId }, { it.percentage })

        LOGGER.info("Applying Discount to ${products.size} Products.")

        products.forEach {
            val discount = discountsPerProduct[it.externalId]
            it.applyDiscount(discount!!)
        }

        LOGGER.debug("DiscountedProducts: $products")

        return products
    }

    override fun getDiscounts(products: List<Product>, userId: String): List<Discount>? {

        val discountsResponse = serverClient.requestDiscounts(userId, products)

        LOGGER.info("Received ${discountsResponse.size} discounts from Discounts Server")

        return discountsResponse.map { Discount(it.productId, it.discount) }
    }
}
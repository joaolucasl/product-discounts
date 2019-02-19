package com.github.joaolucasl.chumlee.products.application.services.impl

import com.github.joaolucasl.chumlee.DiscountServiceGrpc
import com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest
import com.github.joaolucasl.chumlee.products.application.services.DiscountCalculationService
import com.github.joaolucasl.chumlee.products.domain.Discount
import com.github.joaolucasl.chumlee.products.domain.Product
import com.github.joaolucasl.chumlee.products.infrastructure.Environment
import io.grpc.ManagedChannelBuilder
import org.slf4j.LoggerFactory

class DiscountCalculationServiceImpl : DiscountCalculationService {

    private val LOGGER = LoggerFactory.getLogger(javaClass)

    override fun getDiscounts(products: List<Product>, userId: String): List<Discount>? {
        val discountRequest = DiscountRequest.newBuilder()
            .setProductId("PRO-AAAAAAAAAAAA")
            .setUserId("USR-AAAAAAAAAAAA")
            .build()

        val channel = ManagedChannelBuilder
            .forAddress(
                Environment.DISCOUNTS_SERVER,
                Environment.DISCOUNTS_PORT.toInt()
            )
            .usePlaintext(true)
            .build()

        val serviceStub = DiscountServiceGrpc.newBlockingStub(channel)

        val response = serviceStub.getDiscount(discountRequest)

        LOGGER.info(response.toString())

        return null
    }
}
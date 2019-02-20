package com.github.joaolucasl.chumlee.products.infrastructure

import com.github.joaolucasl.chumlee.DiscountServiceGrpc
import com.github.joaolucasl.chumlee.DiscountServiceOuterClass.ProductDiscount
import com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse
import com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest
import com.github.joaolucasl.chumlee.DiscountServiceOuterClass.Product as ProtoProduct
import com.github.joaolucasl.chumlee.products.domain.Discount
import com.github.joaolucasl.chumlee.products.domain.Product
import io.grpc.ManagedChannelBuilder

class DiscountsServerClient {
    private val channel = ManagedChannelBuilder
        .forAddress(
            Environment.DISCOUNTS_SERVER,
            Environment.DISCOUNTS_PORT.toInt()
        )
        .usePlaintext(true)
        .build()

    private val serviceStub = DiscountServiceGrpc.newBlockingStub(channel)

    fun requestDiscounts(userId: String, products: List<Product>): List<ProductDiscount> {
        val protoProducts = products.map { ProtoProduct.newBuilder().setId(it.externalId).build() }
        val discountRequest = DiscountRequest
            .newBuilder()
            .setUserId(userId)
            .addAllProducts(protoProducts).build()

        val response: DiscountResponse = serviceStub.getDiscount(discountRequest)

        return response.productsList
    }
}
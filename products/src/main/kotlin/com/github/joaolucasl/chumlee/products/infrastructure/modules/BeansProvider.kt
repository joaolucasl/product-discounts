package com.github.joaolucasl.chumlee.products.infrastructure.modules

import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.application.services.impl.ProductsServiceImpl
import com.github.joaolucasl.chumlee.products.interfaces.controllers.ProductsController
import org.koin.dsl.module.module
import org.koin.spark.controller

class BeansProvider {
    companion object {
        val module = module {
            single<ProductsService> { ProductsServiceImpl() }
            controller { ProductsController(get()) }
        }
    }
}
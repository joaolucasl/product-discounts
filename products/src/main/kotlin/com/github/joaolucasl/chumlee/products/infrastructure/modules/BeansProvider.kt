package com.github.joaolucasl.chumlee.products.infrastructure.modules

import com.github.joaolucasl.chumlee.products.application.services.DiscountCalculationService
import com.github.joaolucasl.chumlee.products.application.services.ProductsService
import com.github.joaolucasl.chumlee.products.application.services.impl.DiscountCalculationServiceImpl
import com.github.joaolucasl.chumlee.products.application.services.impl.ProductsServiceImpl
import com.github.joaolucasl.chumlee.products.infrastructure.Environment
import com.github.joaolucasl.chumlee.products.infrastructure.Environment.DATABASE_PASSWORD
import com.github.joaolucasl.chumlee.products.infrastructure.Environment.DATABASE_URI
import com.github.joaolucasl.chumlee.products.infrastructure.Environment.DATABASE_USER
import com.github.joaolucasl.chumlee.products.infrastructure.persistence.repository.ProductsRepository
import com.github.joaolucasl.chumlee.products.interfaces.controllers.ProductsController
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.onDemand
import org.koin.dsl.module.module
import org.koin.spark.controller

class BeansProvider {
    companion object {
        val module = module {

            single<Jdbi> {
                Jdbi.create(
                    DATABASE_URI,
                    DATABASE_USER,
                    DATABASE_PASSWORD
                )
                .installPlugin(KotlinPlugin())
                .installPlugin(SqlObjectPlugin())
                .installPlugin(KotlinSqlObjectPlugin())
            }

            single<ProductsRepository> { get<Jdbi>().onDemand() }
            single<ProductsService> { ProductsServiceImpl(get()) }
            single<DiscountCalculationService> { DiscountCalculationServiceImpl() }

            controller { ProductsController(get(), get()) }
        }
    }
}
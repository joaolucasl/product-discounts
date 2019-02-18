package com.github.joaolucasl.chumlee.products

import com.github.joaolucasl.chumlee.products.infrastructure.modules.BeansProvider
import org.koin.spark.start
import java.lang.System.getenv

fun main() {
    start(
        port = getenv("SERVER_PORT").toInt(),
        modules = listOf(BeansProvider.module)
    )
}
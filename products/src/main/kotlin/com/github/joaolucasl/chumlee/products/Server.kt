package com.github.joaolucasl.chumlee.products

import com.github.joaolucasl.chumlee.products.infrastructure.Environment
import com.github.joaolucasl.chumlee.products.infrastructure.modules.BeansProvider
import org.koin.spark.start
import java.lang.System.getenv

fun main(args: Array<String>) {
    println(Environment)
    start(
        port = getenv("SERVER_PORT").toInt(),
        modules = listOf(BeansProvider.module)
    )
}
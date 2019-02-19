package com.github.joaolucasl.chumlee.products.infrastructure

import java.lang.System.getenv

object Environment {
    val DATABASE_URI: String = getenv("DATABASE_URI")
    val DATABASE_USER: String = getenv("DATABASE_USER")
    val DATABASE_PASSWORD: String = getenv("DATABASE_PASSWORD")
}
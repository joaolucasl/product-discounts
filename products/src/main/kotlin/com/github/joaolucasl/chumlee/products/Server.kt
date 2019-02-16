package com.github.joaolucasl.chumlee.products
import io.javalin.Context
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun main() {

    val app = Javalin.create().start(5000)

    app.routes {
        path("/") {
            get { ctx: Context ->
                ctx.result("Hello World!!")
            }
        }
    }
}
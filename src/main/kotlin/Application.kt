package com.geovannycode

import com.geovannycode.datasource.DatabaseFactory
import com.geovannycode.di.appModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.connect()

    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }

    configureRouting()
    configureSerialization()
}

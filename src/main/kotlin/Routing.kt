package com.geovannycode

import com.geovannycode.routes.speakerRoute
import com.geovannycode.services.SpeakerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("¡Servidor Ktor funcionando!", ContentType.Text.Plain)
        }
        val speakerService by inject<SpeakerService>()
        speakerRoute(speakerService)
    }
}

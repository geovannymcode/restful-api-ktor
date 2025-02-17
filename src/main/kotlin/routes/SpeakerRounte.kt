package com.geovannycode.routes

import com.geovannycode.model.Speaker
import com.geovannycode.services.SpeakerService
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.response.*

fun Route.speakerRoute(service: SpeakerService) {

    route("api/speakers") {
        get() {
            call.respond(service.getAll())
        }

        post {
            val speaker = call.receive<Speaker>()
            val savedSpeaker = service.save(speaker)
            call.respond(status = HttpStatusCode.Created, savedSpeaker)
        }

        get("{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: return@get call.respond(HttpStatusCode.BadRequest, "ID inválido")

            val speaker = service.getById(id)
                ?: return@get call.respond(HttpStatusCode.NotFound, "Speaker no encontrado")

            call.respond(speaker)
        }

        put("{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: return@put call.respond(HttpStatusCode.BadRequest, "ID inválido")

            val speaker = call.receive<Speaker>()
            val updatedSpeaker = service.update(id, speaker)
                ?: return@put call.respond(HttpStatusCode.NotFound, "Speaker no encontrado")

            call.respond(HttpStatusCode.OK, updatedSpeaker)
        }

        delete("{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: return@delete call.respond(HttpStatusCode.BadRequest, "ID inválido")

            if (service.delete(id)) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, "Speaker no encontrado")
            }
        }

    }
}
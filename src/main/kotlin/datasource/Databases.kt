package com.geovannycode.datasource

import com.geovannycode.entity.SpeakerEntity
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
        fun connect() {
            Database.connect(
                url = "jdbc:postgresql://localhost:15432/speakers_db",
                driver = "org.postgresql.Driver",
                user = "postgresql",
                password = "postgresql"
            )
            transaction {
                SchemaUtils.create(SpeakerEntity)
            }
        }
    }

package com.geovannycode.datasource

import org.jetbrains.exposed.sql.*

object DatabaseFactory {
        fun connect() {
            Database.connect(
                url = "jdbc:postgresql://localhost:5432/speakers_db",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "postgres"
            )
        }
    }

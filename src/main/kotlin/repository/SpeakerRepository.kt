package com.geovannycode.repository

import com.geovannycode.entity.SpeakerEntity
import com.geovannycode.model.Speaker
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class SpeakerRepository {
    fun getAll(): List<Speaker> = transaction {
        SpeakerEntity.selectAll().map { toSpeaker(it) }
    }

    fun getById(id: Int): Speaker? = transaction {
        SpeakerEntity
            .selectAll()
            .where { SpeakerEntity.id eq id }
            .mapNotNull { toSpeaker(it) }
            .singleOrNull()
    }

    fun save(speaker: Speaker): Speaker = transaction {
        val id = SpeakerEntity.insertAndGetId {
            it[name] = speaker.name
            it[country] = speaker.country
            it[biography] = speaker.biography
            it[email] = speaker.email
            it[twitterHandle] = speaker.twitterHandle
        }.value
        speaker.copy(id = id)
    }

    fun delete(id: Int): Boolean = transaction {
        SpeakerEntity.deleteWhere { SpeakerEntity.id eq id } > 0
    }

    fun update(id: Int, speaker: Speaker): Speaker? = transaction {
        val updatedRows = SpeakerEntity.update({ SpeakerEntity.id eq id }) {
            it[name] = speaker.name
            it[country] = speaker.country
            it[biography] = speaker.biography
            it[email] = speaker.email
            it[twitterHandle] = speaker.twitterHandle
        }
        if (updatedRows > 0) getById(id) else null
    }

    private fun toSpeaker(row: ResultRow): Speaker =
        Speaker(
            id = row[SpeakerEntity.id].value,
            name = row[SpeakerEntity.name],
            country = row[SpeakerEntity.country],
            biography = row[SpeakerEntity.biography],
            email = row[SpeakerEntity.email],
            twitterHandle = row[SpeakerEntity.twitterHandle]
        )
}
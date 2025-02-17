package com.geovannycode.repository

import com.geovannycode.model.Speaker
import org.jetbrains.exposed.sql.*

class SpeakerRepository {
    fun get() = datab.values
    fun get(id: Int): Speaker? = db[id]
    fun save(speaker: Speaker): Speaker {
        speaker.id = getId()
        db[getId()] = speaker
        return speaker
    }

    fun delete(id: Int) = db.remove(id)

    fun update(id: Int, speaker: Speaker): Speaker? = db.replace(id, speaker)
}
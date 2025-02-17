package com.geovannycode.services

import com.geovannycode.model.Speaker
import com.geovannycode.repository.SpeakerRepository

class SpeakerService(private val repository: SpeakerRepository) {
    suspend fun save(speaker: Speaker): Speaker = repository.save(speaker)

    suspend fun getAll() = repository.getAll()

    suspend fun getById(id: Int) = repository.getById(id)

    suspend fun delete(id: Int): Boolean = repository.delete(id)

    suspend fun update(id: Int, speaker: Speaker): Speaker? {
        return repository.update(id, speaker.copy(id = id))
    }
}

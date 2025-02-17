package com.geovannycode.entity

import org.jetbrains.exposed.dao.id.IntIdTable

object SpeakerEntity : IntIdTable("speakers") {
    val name = varchar("name", 100)
    val country = varchar("country", 100)
    val biography = text("biography")
    val email = varchar("email", 255)
    val twitterHandle = varchar("twitter_handle", 50).nullable()
}
package com.learning.data.entity

import com.learning.domain.model.Genre
import com.learning.domain.model.Platform
import java.time.LocalDateTime
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "game", schema = "toyapp")
data class GameEntity (
    @Id
    val id: Long = 0L,
    val title: String = "",
    val platform: Platform? = null,
    val finished: Boolean = false,
    val rating: Int = 0,
    val genre: Collection<Genre> = emptyList(),
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

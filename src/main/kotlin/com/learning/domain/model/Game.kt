package com.learning.domain.model

import java.time.LocalDateTime

data class Game(
    val id: Long = 0,
    val title: String = "",
    val platform: Platform? = null,
    val finished: Boolean = false,
    val rating: Int = 0,
    val genre: Collection<Genre> = emptyList(),
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

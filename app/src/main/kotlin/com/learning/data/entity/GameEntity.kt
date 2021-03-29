package com.learning.data.entity

import com.learning.domain.model.Genre
import com.learning.domain.model.Platform
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "game", schema = "toyapp")
data class GameEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val title: String = "",
    val platform: Platform? = null,
    val finished: Boolean = false,
    val rating: Int = 0,
    val genre: Genre? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

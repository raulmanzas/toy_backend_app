package com.learning.domain.persistence

import com.learning.domain.model.Game
import java.util.*

interface GameRepository {
    fun persist(game: Game): Game
    fun findById(id: Long): Optional<Game>
    fun findGameByTitle(title: String): Optional<Game>
}

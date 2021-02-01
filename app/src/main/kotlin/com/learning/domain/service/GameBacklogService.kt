package com.learning.domain.service

import com.learning.domain.model.Game
import java.util.Optional

interface GameBacklogService {
    fun addGameToBacklog(game: Game): Game
    fun findGameById(id: Long): Optional<Game>
}

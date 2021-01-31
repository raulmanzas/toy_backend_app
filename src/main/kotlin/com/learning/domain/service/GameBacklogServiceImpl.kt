package com.learning.domain.service

import com.learning.domain.model.Game
import java.util.Optional
import javax.inject.Singleton

@Singleton
class GameBacklogServiceImpl: GameBacklogService {
    override fun addGameToBacklog(game: Game): Game {
        return Game()
    }

    override fun findGameById(id: Long): Optional<Game> {
        return Optional.empty()
    }
}

package com.learning.data.repository

import com.learning.domain.model.Game
import com.learning.domain.persistence.GameRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl: GameRepository {

    override fun persist(game: Game): Game {
        return Game()
    }

    override fun findById(id: Long): Optional<Game> {
        return Optional.empty()
    }
}

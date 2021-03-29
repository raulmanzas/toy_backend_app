package com.learning.data.repository

import com.learning.domain.model.Game
import com.learning.domain.persistence.GameRepository
import com.learning.data.entity.asDomain
import com.learning.data.entity.asEntity
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
internal class GameRepositoryAdapter(
    private val jpaGameRepository: JpaGameRepository
): GameRepository {

    companion object {
        private val logger = LoggerFactory.getLogger(GameRepositoryAdapter::class.java)
    }

    override fun persist(game: Game): Game {
        val persistedGame = jpaGameRepository.save(game.asEntity())
        logger.info("game {} persisted with id {}", persistedGame.title, persistedGame.id)
        return persistedGame.asDomain()
    }

    override fun findById(id: Long): Optional<Game> {
        return Optional.empty()
    }

    override fun findGameByTitle(title: String): Optional<Game> {
        val gameEntity = jpaGameRepository.findByTitle(title)
        if (gameEntity.isEmpty)
            return Optional.empty()
        return Optional.of(gameEntity.get().asDomain())
    }
}

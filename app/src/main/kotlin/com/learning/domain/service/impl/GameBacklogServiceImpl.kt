package com.learning.domain.service.impl

import com.learning.domain.exception.GameAlreadyOnBacklogException
import com.learning.domain.model.Game
import com.learning.domain.persistence.GameRepository
import com.learning.domain.service.GameBacklogService
import com.learning.endpoint.GameBacklogEndpoint
import org.slf4j.LoggerFactory
import java.util.Optional
import javax.inject.Singleton

@Singleton
internal class GameBacklogServiceImpl(
    private val gameRepository: GameRepository
): GameBacklogService {

    companion object {
        private val logger = LoggerFactory.getLogger(GameBacklogServiceImpl::class.java)
    }

    override fun addGameToBacklog(game: Game): Game {
        game.validate()
        gameRepository.findGameByTitle(game.title).ifPresent {
            logger.error("Duplicate game found: ${it.title}")
            throw GameAlreadyOnBacklogException(it.title, it.id)
        }
        logger.info("game {} is valid and is going to be persisted", game.title)
        return gameRepository.persist(game)
    }

    override fun findGameById(id: Long): Optional<Game> {
        return Optional.empty()
    }
}

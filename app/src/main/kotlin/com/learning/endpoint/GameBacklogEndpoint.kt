package com.learning.endpoint

import com.learning.domain.service.GameBacklogService
import com.learning.endpoint.mapper.asGrpcMessage
import com.learning.endpoint.mapper.asGrpcStatusError
import com.learning.endpoint.mapper.asModel
import com.learning.generated.grpc.AddToBacklogRequest
import com.learning.generated.grpc.AddToBacklogResponse
import com.learning.generated.grpc.FindGameRequest
import com.learning.generated.grpc.FindGameResponse
import com.learning.generated.grpc.GameBacklogServiceGrpcKt.GameBacklogServiceCoroutineImplBase
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class GameBacklogEndpoint(
    private val gameBacklogService: GameBacklogService
): GameBacklogServiceCoroutineImplBase() {

    companion object {
        private val logger = LoggerFactory.getLogger(GameBacklogEndpoint::class.java)
    }

    override suspend fun addToBacklog(request: AddToBacklogRequest): AddToBacklogResponse {
        try {
            logger.info("received request to add game to backlog: {}", request)
            val newGame = request.asModel()
            val persistedGame = gameBacklogService.addGameToBacklog(newGame).asGrpcMessage()
            logger.info("response to add game to backlog request for {} -> {}", newGame.title, persistedGame)
            return persistedGame
        } catch (e: Exception){
            logger.error("error while processing addToBacklog: {} ", e.message)
            throw e.asGrpcStatusError()
        }
    }

    override suspend fun findGame(request: FindGameRequest): FindGameResponse {
        logger.info("received request to find game: {}", request)
        return super.findGame(request)
    }
}

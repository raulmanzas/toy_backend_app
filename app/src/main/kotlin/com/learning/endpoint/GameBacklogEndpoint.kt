package com.learning.endpoint

import com.learning.domain.service.GameBacklogService
import com.learning.endpoint.mapper.asGrpcMessage
import com.learning.endpoint.mapper.asModel
import com.learning.generated.grpc.AddToBacklogRequest
import com.learning.generated.grpc.AddToBacklogResponse
import com.learning.generated.grpc.FindGameRequest
import com.learning.generated.grpc.FindGameResponse
import com.learning.generated.grpc.GameBacklogServiceGrpcKt.GameBacklogServiceCoroutineImplBase
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class GameBacklogEndpoint(
    private val gameBacklogService: GameBacklogService
): GameBacklogServiceCoroutineImplBase() {

    override suspend fun addToBacklog(request: AddToBacklogRequest): AddToBacklogResponse {
        val newGame = request!!.asModel()
        val game = gameBacklogService.addGameToBacklog(newGame)
        return game.asGrpcMessage()
    }

    override suspend fun findGame(request: FindGameRequest): FindGameResponse {
        return super.findGame(request)
    }
}

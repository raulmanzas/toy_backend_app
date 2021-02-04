package com.learning.endpoint

import com.learning.domain.service.GameBacklogService
import com.learning.endpoint.mapper.asGrpcMessage
import com.learning.endpoint.mapper.asModel
import com.learning.generated.grpc.AddToBacklogRequest
import com.learning.generated.grpc.AddToBacklogResponse
import com.learning.generated.grpc.FindGameRequest
import com.learning.generated.grpc.FindGameResponse
import com.learning.generated.grpc.GameBacklogServiceGrpc.GameBacklogServiceImplBase
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class GameBacklogEndpoint(
    private val gameBacklogService: GameBacklogService
): GameBacklogServiceImplBase() {

    override fun addToBacklog(request: AddToBacklogRequest?, responseObserver: StreamObserver<AddToBacklogResponse>?) {
        val newGame = request!!.asModel()
        val game = gameBacklogService.addGameToBacklog(newGame)
        responseObserver!!.onNext(game.asGrpcMessage())
        responseObserver.onCompleted()
    }

    override fun findGame(request: FindGameRequest?, responseObserver: StreamObserver<FindGameResponse>?) {
        super.findGame(request, responseObserver)
    }
}

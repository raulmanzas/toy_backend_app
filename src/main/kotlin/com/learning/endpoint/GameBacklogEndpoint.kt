package com.learning.endpoint

import com.learning.generated.grpc.AddToBacklogRequest
import com.learning.generated.grpc.AddToBacklogResponse
import com.learning.generated.grpc.GameBacklogServiceGrpc.GameBacklogServiceImplBase
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class GameBacklogEndpoint : GameBacklogServiceImplBase() {
    override fun addToBacklog(request: AddToBacklogRequest?, responseObserver: StreamObserver<AddToBacklogResponse>?) {
        super.addToBacklog(request, responseObserver)
    }
}

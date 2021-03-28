package com.learning.endpoint.mapper

import com.learning.domain.model.Game
import com.learning.domain.model.Genre
import com.learning.domain.model.Platform
import com.learning.generated.grpc.AddToBacklogRequest
import com.learning.generated.grpc.AddToBacklogResponse
import com.learning.generated.grpc.Genre as GrpcGenre

fun AddToBacklogRequest.asModel(): Game {
    return Game(
        title = this.title,
        finished = this.finished,
        rating = this.rating,
        genre = Genre.valueOf(this.genre.name),
        platform = Platform.valueOf(this.platform.name)
    )
}

fun Game.asGrpcMessage(): AddToBacklogResponse {
    return AddToBacklogResponse.newBuilder().apply {
        id = id
        title = title
        platform = platform
        finished = finished
        rating = rating
        creationDate = creationDate
        genre = GrpcGenre.forNumber(genre.number)
    }.build()
}

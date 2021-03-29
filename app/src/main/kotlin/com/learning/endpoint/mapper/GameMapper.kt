package com.learning.endpoint.mapper

import com.learning.domain.model.Game
import com.learning.domain.model.Genre
import com.learning.domain.model.Platform
import com.learning.generated.grpc.AddToBacklogRequest
import com.learning.generated.grpc.AddToBacklogResponse
import com.learning.generated.grpc.Genre as GrpcGenre
import com.learning.generated.grpc.Platform as GrpcPlatform

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
    val model = this
    return AddToBacklogResponse.newBuilder().apply {
        id = model.id
        title = model.title
        platform = GrpcPlatform.valueOf(model.platform!!.name)
        finished = model.finished
        rating = model.rating
        creationDate = model.createdAt.toString()
        genre = GrpcGenre.valueOf(model.genre!!.name)
    }.build()
}

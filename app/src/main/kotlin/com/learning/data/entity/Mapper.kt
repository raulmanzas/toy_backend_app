package com.learning.data.entity

import com.learning.domain.model.Game

fun GameEntity.asDomain(): Game {
    return Game(
        id = id,
        title = title,
        platform = platform,
        finished = finished,
        rating = rating,
        genre = genre,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Game.asEntity(): GameEntity {
    return GameEntity(
        id = id,
        title = title,
        platform = platform,
        finished = finished,
        rating = rating,
        genre = genre,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

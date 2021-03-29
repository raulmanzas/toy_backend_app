package com.learning.data.repository

import com.learning.data.entity.GameEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.Optional

@Repository
internal interface JpaGameRepository: CrudRepository<GameEntity, Long> {
    fun findByTitle(title: String): Optional<GameEntity>
}

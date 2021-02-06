package com.learning.data.repository

import com.learning.data.entity.GameEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
internal interface JpaGameRepository: CrudRepository<GameEntity, Long>

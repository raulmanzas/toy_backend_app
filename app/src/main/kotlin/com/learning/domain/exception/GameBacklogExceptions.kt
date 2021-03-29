package com.learning.domain.exception

data class RatingNotInRangeException(
    override val message: String = "The Game rating should be in range [1,5]"
): Exception(message)

data class FieldNotInformedException(
    private val fieldName: String,
    override val message: String = "The Game $fieldName must be informed"
): Exception(message)

data class GameAlreadyOnBacklogException(
    private val title: String,
    private val id: Long,
    override val message: String = "The Game '$title' is already on backlog with id $id"
): Exception(message)

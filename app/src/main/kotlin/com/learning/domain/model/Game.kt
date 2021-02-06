package com.learning.domain.model

import com.learning.domain.exception.FieldNotInformedException
import com.learning.domain.exception.RatingNotInRangeException
import java.time.LocalDateTime

class Game(
    var id: Long = 0,
    var title: String = "",
    var platform: Platform? = null,
    var finished: Boolean = false,
    var rating: Int = 0,
    var genre: Collection<Genre> = emptyList(),
    var creationDate: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        const val RATING_LOWER_BOUND = 1
        const val RATING_UPPER_BOUND = 5
    }

    fun validate() {
        if (rating < RATING_LOWER_BOUND || rating > RATING_UPPER_BOUND) {
            throw RatingNotInRangeException()
        }
        if (title.isNullOrBlank()) {
            throw FieldNotInformedException("title")
        }
        if (genre.isEmpty()) {
            throw FieldNotInformedException("genre")
        }
        if (platform == null) {
            throw FieldNotInformedException("platform")
        }
    }
}

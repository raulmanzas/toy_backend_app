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
    fun validate() {
        if (rating < 1 || rating > 5) {
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

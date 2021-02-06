package com.learning.domain.model

import com.github.javafaker.Faker
import com.learning.domain.exception.RatingNotInRangeException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class GameTest {

    private val faker = Faker()

    @Test
    fun `when rating is bigger than limit should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.rating = faker.random().nextInt(6, 99)
        assertThrows(RatingNotInRangeException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when rating is smaller than limit should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.rating = faker.random().nextInt(-99, 0)
        assertThrows(RatingNotInRangeException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when rating is in range should not throw validation error`() {
        val lowerBoundGame = buildValidGameInstance()
        val upperBoundGame = buildValidGameInstance()
        lowerBoundGame.rating = 1
        upperBoundGame.rating = 5
        lowerBoundGame.validate()
        upperBoundGame.validate()
    }

    private fun buildValidGameInstance(): Game {
        val faker = Faker()
        return Game(
            title = faker.lordOfTheRings().character(),
            platform = Platform.NINTENDO_SWITCH,
            finished = true,
            rating = faker.random().nextInt(1, 5),
            genre = listOf(Genre.RPG, Genre.ACTION)
        )
    }
}
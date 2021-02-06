package com.learning.domain.model

import com.github.javafaker.Faker
import com.learning.domain.exception.FieldNotInformedException
import com.learning.domain.exception.RatingNotInRangeException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class GameTest {

    private val faker = Faker()

    @Test
    fun `when game rating is bigger than limit should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.rating = faker.random().nextInt(6, 99)
        assertThrows(RatingNotInRangeException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when game rating is smaller than limit should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.rating = faker.random().nextInt(-99, 0)
        assertThrows(RatingNotInRangeException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when game rating is in range should not throw validation error`() {
        val lowerBoundGame = buildValidGameInstance()
        val upperBoundGame = buildValidGameInstance()
        lowerBoundGame.rating = 1
        upperBoundGame.rating = 5
        lowerBoundGame.validate()
        upperBoundGame.validate()
    }

    @Test
    fun `when game title is blank should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.title = "   "
        assertThrows(FieldNotInformedException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when game title is empty should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.title = ""
        assertThrows(FieldNotInformedException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when game genre is empty should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.genre = emptyList()
        assertThrows(FieldNotInformedException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when game platform is null should throw validation error`() {
        val invalidGame = buildValidGameInstance()
        invalidGame.platform = null
        assertThrows(FieldNotInformedException::class.java) {
            invalidGame.validate()
        }
    }

    @Test
    fun `when game instance have valid values should not throw validation error`() {
        val validGame = buildValidGameInstance()
        validGame.validate()
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
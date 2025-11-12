package org.acqic.acquicBot

import org.acqic.acquicBot.utils.firstValueOfKeyMatching
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MapsExtensionsTests {
    @Test
    fun firstValueOfKeyMatchingTest() {
        val mapTestOne = listOf(
            "smth" to 1,
            "else" to 2,
            "smthelse" to 3,
            "smthe" to 4,
        )

        fun func(str: String): Int? =
            mapTestOne.firstValueOfKeyMatching(str)

        fun assertForThis(result: Int, forString: String): Unit =
            assertEquals(result, func(forString))

        assertForThis(1, "smth")
        assertForThis(1, "36264626smth33")
        assertForThis(1, "36264626smth")
        assertForThis(2, " smelse1")
        assertForThis(1, "smthe")
        assertForThis(2, "elsselsesmth")
        assertNull(func("2"))
    }

}
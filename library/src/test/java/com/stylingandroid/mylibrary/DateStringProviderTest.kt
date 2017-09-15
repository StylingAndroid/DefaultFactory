package com.stylingandroid.mylibrary

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class DateStringProviderTest {

    @Nested
    @DisplayName("Given a DateStringProvider instance")
    inner class DateStringProviderInstance {
        val testableClass = DateStringProvider(factory)

        @Nested
        @DisplayName("When we build a date string")
        inner class BuildDateString {
            private val dateString = testableClass.buildDateString()

            @Test
            @DisplayName("Then it should not be empty")
            fun notEmpty() {
                assertThat(dateString).isNotEmpty()
            }

            @Test
            @DisplayName("Then it should equal \"$DATE_STRING\"")
            fun isEqual() {
                assertThat(dateString).isEqualTo(DATE_STRING)
            }
        }
    }

    object factory : DateStringProvider.Factory {
        override fun getLocalDateTime(): LocalDateTime = Mockito.mock(LocalDateTime::class.java)

        override fun getLocalisedDateTimeFormatter(): DateTimeFormatter = mock {
            on {
                format(any())
            } doReturn DATE_STRING
        }
    }

    companion object {
        const val DATE_STRING = "Date String"
    }
}

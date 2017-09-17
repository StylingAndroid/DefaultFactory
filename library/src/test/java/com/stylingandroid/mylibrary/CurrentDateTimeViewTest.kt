package com.stylingandroid.mylibrary

import android.test.mock.MockContext
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class CurrentDateTimeViewTest {
    @Nested
    @DisplayName("Given a CurrentDateTimeView instance")
    inner class CurrentDateTimeViewInstance {
        private val context = MockContext()
        val currentDateTimeView = spy(CurrentDateTimeView(context, factory = factory))

        @Nested
        @DisplayName("When we call update()")
        inner class BuildDateString {

            @BeforeEach
            fun setup() {
                currentDateTimeView.update()
            }

            @Test
            @DisplayName("Then setText() should be called")
            fun notEmpty() {
                verify(currentDateTimeView, atLeastOnce()).text = any()
            }

            @Test
            @DisplayName("Then setText() should be called with \"$DATE_STRING\"")
            fun isEqual() {
                verify(currentDateTimeView, atLeastOnce()).text = stringCaptor.capture()

                assertThat(stringCaptor.value).isEqualTo(DATE_STRING)
            }
        }
    }

    object factory : CurrentDateTimeView.Factory {
        override fun getLocalDateTime(): LocalDateTime = mock {}

        override fun getLocalisedDateTimeFormatter(): DateTimeFormatter = mock {
            on {
                format(any())
            } doReturn DateStringProviderTest.DATE_STRING
        }
    }

    val stringCaptor: ArgumentCaptor<String> = ArgumentCaptor.forClass(String::class.java)

    companion object {
        const val DATE_STRING = "Date String"
    }
}

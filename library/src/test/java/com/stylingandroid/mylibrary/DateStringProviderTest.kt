package com.stylingandroid.mylibrary

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.FreeSpec
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class DateStringProviderTest : FreeSpec() { init {

    "Given a DateStringProvider instance" - {
        val DATE_STRING = "Date String"
        val fakeDate : LocalDateTime = mock {  }
        val formatter : DateTimeFormatter =  mock {
            on { format(any()) } doReturn DATE_STRING
        }

        val testableClass = DateStringProvider(formatter, { fakeDate })

        "When we build a date string" - {
            val dateString: String = testableClass.buildDateString()

            "Then it should not be empty" {
                dateString shouldNotBe ""
            }
            "Then it should be equal to $DATE_STRING" {
                dateString shouldBe DATE_STRING
            }
        }

    }
}
}

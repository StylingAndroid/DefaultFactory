package com.stylingandroid.mylibrary

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.FreeSpec

class DateStringProviderTest : FreeSpec() { init {

    val DATE_STRING = "Date String"

    "Given a DateStringProvider instance" - {
        val testableClass = DateStringProvider(
                localDateTime = mock { },
                localisazedDatetimeFormatter = mock {
                    on {
                        format(any())
                    } doReturn DATE_STRING
                }
        )

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

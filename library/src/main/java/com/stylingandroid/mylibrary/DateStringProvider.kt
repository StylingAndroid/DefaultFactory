package com.stylingandroid.mylibrary

import com.stylingandroid.mylibrary.DateStringProvider.Companion.defaultFormatter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

typealias LocalTimeProvider = () -> LocalDateTime

class DateStringProvider(
        val localisazedDatetimeFormatter : DateTimeFormatter = defaultFormatter,
        val localDateTimeProvider : LocalTimeProvider = DateStringProvider.defaultLocaltimeProvider
) {
    companion object {
        val defaultFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
        val defaultLocaltimeProvider : LocalTimeProvider = { LocalDateTime.now() }
    }

    fun buildDateString() : String =
            localisazedDatetimeFormatter.format(localDateTimeProvider())
}

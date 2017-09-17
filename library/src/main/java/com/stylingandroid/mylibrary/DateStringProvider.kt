package com.stylingandroid.mylibrary

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class DateStringProvider(
        val localisazedDatetimeFormatter : DateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL),
        val localDateTime : LocalDateTime = LocalDateTime.now()
) {

    fun buildDateString() : String =
            localisazedDatetimeFormatter.format(localDateTime)
}

package com.stylingandroid.mylibrary

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class DateStringProvider internal constructor(private val factory: Factory) {

    constructor() : this(DefaultFactory)

    fun buildDateString() =
            factory.getLocalisedDateTimeFormatter().format(factory.getLocalDateTime()) as String

    internal interface Factory {
        fun getLocalDateTime(): LocalDateTime
        fun getLocalisedDateTimeFormatter(): DateTimeFormatter
    }

    private object DefaultFactory : Factory {
        override fun getLocalisedDateTimeFormatter(): DateTimeFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)

        override fun getLocalDateTime(): LocalDateTime = LocalDateTime.now()
    }
}

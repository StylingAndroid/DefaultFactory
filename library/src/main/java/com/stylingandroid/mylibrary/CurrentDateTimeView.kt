package com.stylingandroid.mylibrary

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class CurrentDateTimeView internal constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        private val factory: Factory,
        private val formatter: DateTimeFormatter = factory.getLocalisedDateTimeFormatter()
) : TextView(context, attrs, defStyleAttr) {

    @JvmOverloads constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0) : this(context, attrs, defStyleAttr, DefaultFactory)

    fun update() {
        text = formatter.format(factory.getLocalDateTime())
    }

    interface Factory {
        fun getLocalDateTime(): LocalDateTime
        fun getLocalisedDateTimeFormatter(): DateTimeFormatter
    }

    private object DefaultFactory : Factory {
        override fun getLocalisedDateTimeFormatter(): DateTimeFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)

        override fun getLocalDateTime(): LocalDateTime = LocalDateTime.now()
    }
}

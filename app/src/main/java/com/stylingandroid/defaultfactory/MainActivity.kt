package com.stylingandroid.defaultfactory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.stylingandroid.mylibrary.DateStringProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(DateStringProvider().buildDateString())

        current_date_time.update()
    }
}

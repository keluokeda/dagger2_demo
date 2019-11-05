package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class HttpActivity : AppCompatActivity() {

    @Inject
    lateinit var httpService: HttpService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        DaggerHttpComponent.create().inject(this)

        httpService.id.log()
    }
}

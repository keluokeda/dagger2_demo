package com.ke.dagger2_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        model = DaggerSecondComponent.create().getModel()

        model.uuid.log()
    }
}

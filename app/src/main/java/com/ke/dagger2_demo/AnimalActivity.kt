package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject
import javax.inject.Named

class AnimalActivity : AppCompatActivity() {


    @CatAnimal
    @Inject
    lateinit var animal: Animal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)


        DaggerAnimalComponent.create().inject(this)

        animal.toString().log()

    }
}

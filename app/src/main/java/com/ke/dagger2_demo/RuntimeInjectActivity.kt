package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class RuntimeInjectActivity : AppCompatActivity() {


    @Inject
    lateinit var bike: Bike

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime_inject)

        DaggerBikeComponent.builder().bikeModule(BikeModule(100))
            .build().inject(this)

        "bike price = ${bike.price}".log()

    }
}


data class Bike(val price: Int)


@Module
class BikeModule(private val price: Int) {

    @Provides
    fun providePrice():Int = price


    @Provides
    fun provideBike(): Bike {
        return Bike(price)
    }
}

@Component(modules = [BikeModule::class])
interface BikeComponent {

    fun inject(runtimeInjectActivity: RuntimeInjectActivity)
}



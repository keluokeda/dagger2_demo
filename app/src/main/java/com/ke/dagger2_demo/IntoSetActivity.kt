package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Inject

class IntoSetActivity : AppCompatActivity() {


    @Inject
    lateinit var carSet: Set<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_into_set)

        DaggerCarComponent.create().inject(this)

        carSet.forEach {
            it.toString().log()
        }

    }
}


data class Car(val name: String)

@Module
class CarModule {

    @Provides
    @IntoSet
    fun provideA(): Car {
        return Car("A")
    }

    @Provides
    @IntoSet
    fun provideB(): Car {
        return Car("B")
    }
}

@Component(modules = [CarModule::class])
interface CarComponent {

    fun inject(intoSetActivity: IntoSetActivity)
}
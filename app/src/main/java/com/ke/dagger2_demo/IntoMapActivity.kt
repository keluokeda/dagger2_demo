package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import javax.inject.Inject

class IntoMapActivity : AppCompatActivity() {


    @Inject
    lateinit var foodMap: Map<String, Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_into_map)

        DaggerFoodComponent.create().inject(this)


        foodMap.forEach {
            "key = ${it.key} , value = ${it.value}".log()
        }

    }
}


data class Food(val name: String)

@Module
class FoodModule {

    @IntoMap
    @Provides
    @StringKey("apple")
    fun provideApple(): Food {
        return Food("apple")
    }


    @IntoMap
    @Provides
    @StringKey("milk")
    fun provideMilk(): Food {
        return Food("milk")
    }
}

@Component(modules = [FoodModule::class])
interface FoodComponent {
    fun inject(intoMapActivity: IntoMapActivity)
}
package com.ke.dagger2_demo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class BuilderActivity : AppCompatActivity() {


    @Inject
    lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)

        DaggerComputerComponent.builder()
            .application(application)
            .build()
            .inject(this)

    }
}


data class Computer(val name: String)


@Module
class ComputerModule {

    @Provides
    @Singleton
    fun provideComputer(application: Application): Computer {
        return Computer(application.packageName)
    }
}

@Singleton
@Component(modules = [ComputerModule::class])
interface ComputerComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ComputerComponent


    }

    fun inject(builderActivity: BuilderActivity)

}
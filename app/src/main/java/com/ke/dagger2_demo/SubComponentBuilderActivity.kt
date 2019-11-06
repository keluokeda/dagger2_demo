package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.*
import javax.inject.Inject

class SubComponentBuilderActivity : AppCompatActivity() {


    @Inject
    lateinit var father: Father

    @Inject
    lateinit var son: Son

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_component_builder)

        DaggerFatherComponent.builder().build().createSonBuilder().name("hankuke").build()
            .inject(this)


        "father = $father son father = ${son.father}".log()
    }
}


class Father

class Son (val father: Father)


@Module
class FatherModule {


    @Provides
    fun provideFather(): Father = Father()
}


@Module
class SonModule {


    @Provides
    fun provideSon(name: String, father: Father): Son {
        "son mame = $name".log()

        return Son(father)
    }
}

@Component(modules = [FatherModule::class])
interface FatherComponent {

    fun createSonBuilder(): SonComponent.Builder
}

@Subcomponent(modules = [SonModule::class])
interface SonComponent {

    fun inject(subComponentBuilderActivity: SubComponentBuilderActivity)


    @Subcomponent.Builder
    interface Builder {

        fun build(): SonComponent

        @BindsInstance
        fun name(name: String): Builder
    }
}
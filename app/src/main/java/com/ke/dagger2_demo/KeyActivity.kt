package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named

class KeyActivity : AppCompatActivity() {


    @Named("amap")
    @Inject
    lateinit var key: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key)



        DaggerKeyComponent.create().inject(this)

        key.log()
    }
}


@Module
class KeyModule {

    @Named("amap")
    @Provides
    fun provideAmapKey(): String = "amap"


    @Named("baidu")
    @Provides
    fun provideBaiduKey(): String = "baidu"
}

@Component(modules = [KeyModule::class])
interface KeyComponent {

    fun inject(keyActivity: KeyActivity)
}
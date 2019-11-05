package com.ke.dagger2_demo

import dagger.Module
import dagger.Provides

@Module
class IdModule {


    @Provides
    fun provideId(): String = "123456"
}
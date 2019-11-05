package com.ke.dagger2_demo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}
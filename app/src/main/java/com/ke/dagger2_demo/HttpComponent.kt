package com.ke.dagger2_demo

import dagger.Component

@Component(modules = [HttpServiceModule::class])
interface HttpComponent {

    fun inject(httpActivity: HttpActivity)
}
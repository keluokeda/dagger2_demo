package com.ke.dagger2_demo

import dagger.Module
import dagger.Provides

@Module(includes = [IdModule::class])
class HttpServiceModule {
    @Provides
    fun provideHttpService(id: String): HttpService {
        return HttpService(id)
    }
}
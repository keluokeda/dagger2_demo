package com.ke.dagger2_demo

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

interface Animal


class Dog : Animal {
    override fun toString(): String {
        return "dog"
    }
}

class Cat : Animal {
    override fun toString(): String {
        return "cat"
    }
}


@Module
class AnimalModule {


    @DogAnimal
    @Provides
    fun provideDog(): Animal = Dog()

    @CatAnimal
    @Provides
    fun provideCat(): Animal = Cat()
}


@Component(modules = [AnimalModule::class])
interface AnimalComponent {

    fun inject(animalActivity: AnimalActivity)
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DogAnimal

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CatAnimal
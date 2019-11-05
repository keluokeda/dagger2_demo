package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

class PeopleActivity : AppCompatActivity() {

    @Inject
    lateinit var people1: People

    @Inject
    lateinit var people2: People


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)


        DaggerPeopleComponent.create().inject(this)

        "$people1 $people2 ${people1 === people2}".log()
    }
}


@Singleton
class People @Inject constructor()


@Singleton
@Component
interface PeopleComponent {

    fun inject(peopleActivity: PeopleActivity)
}
package com.ke.dagger2_demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var model1: Model

    @Inject
    lateinit var model2: Model


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.builder().build().inject(this)
        model1.uuid.log()
        model2.uuid.log()
        second.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        http.setOnClickListener {
            startActivity(Intent(this, HttpActivity::class.java))
        }

        animal.setOnClickListener {
            startActivity(Intent(this, AnimalActivity::class.java))
        }

        key.setOnClickListener {
            startActivity(Intent(this, KeyActivity::class.java))
        }

        people.setOnClickListener {
            startActivity(Intent(this, PeopleActivity::class.java))
        }

        weapon.setOnClickListener {
            startActivity(Intent(this, WeaponActivity::class.java))
        }

        into_set.setOnClickListener {
            startActivity(Intent(this, IntoSetActivity::class.java))
        }
        into_map.setOnClickListener {
            startActivity(Intent(this, IntoMapActivity::class.java))
        }

        runtime_inject.setOnClickListener {
            startActivity(Intent(this, RuntimeInjectActivity::class.java))
        }

        sub_component.setOnClickListener {
            startActivity(Intent(this, SubComponentActivity::class.java))
        }

        sub_component_builder.setOnClickListener {
            startActivity(Intent(this, SubComponentBuilderActivity::class.java))
        }
    }
}

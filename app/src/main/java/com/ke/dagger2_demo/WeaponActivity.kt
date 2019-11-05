package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class WeaponActivity : AppCompatActivity() {

    @Inject
    lateinit var weapon: Weapon


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon)

        DaggerWeaponComponent.create().inject(this)

        weapon.attack()
    }
}


interface Weapon {
    fun attack()
}

class Gun @Inject constructor() : Weapon {
    override fun attack() {
        "gun attack".log()
    }
}

class Sword @Inject constructor() : Weapon {
    override fun attack() {
        "sword attack".log()
    }
}


@Module
abstract class WeaponModule {


    @Binds
    abstract fun bindWeapon(gun: Gun): Weapon

}

@Component(modules = [WeaponModule::class])
interface WeaponComponent {
    fun inject(weaponActivity: WeaponActivity)
}


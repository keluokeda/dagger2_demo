package com.ke.dagger2_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

class SubComponentActivity : AppCompatActivity() {

    @Inject
    lateinit var memberA: MemberA


    @Inject
    lateinit var memberB: MemberB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_component)


        val daggerMemberComponent = DaggerMemberComponent.create()


        DaggerMemberAComponent
            .builder()
            .memberAModule(MemberAModule())
            .memberComponent(daggerMemberComponent)
            .build()
            .inject(this)

        memberA.toString().log()


        daggerMemberComponent.createSub().inject(this)


        memberB.toString().log()
    }


}


class Member

class MemberA @Inject constructor(val member: Member)

class MemberB @Inject constructor(val member: Member)


@Module
class MemberModule {


    @Provides
    fun provideMember(): Member {
        return Member()
    }
}


@Module
class MemberAModule {

    @Provides
    fun provideMemberA(member: Member): MemberA {
        return MemberA(member)
    }
}

@Module
class MemberBModule {

    @Provides
    fun provideMemberB(member: Member): MemberB {
        return MemberB(member)
    }
}

@Component(modules = [MemberModule::class])
interface MemberComponent {


    //暴露member对象，方便其他component调用
    fun member(): Member


    //返回一个SubComponent 
    fun createSub(): MemberBComponent

}



@Subcomponent(modules = [MemberBModule::class])
interface MemberBComponent {

    fun inject(subComponentActivity: SubComponentActivity)
}

@Component(modules = [MemberAModule::class], dependencies = [MemberComponent::class])
interface MemberAComponent {

    fun inject(subComponentActivity: SubComponentActivity)
}
package com.ke.dagger2_demo

import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
data class Model constructor(
    val uuid: String
) {
    @Inject
    constructor() : this(UUID.randomUUID().toString())
}
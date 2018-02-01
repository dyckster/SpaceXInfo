package com.dyckster.spacextest.data.mapper

interface Mapper<in Entity, out Model> {

    fun transform(input: Entity): Model
}
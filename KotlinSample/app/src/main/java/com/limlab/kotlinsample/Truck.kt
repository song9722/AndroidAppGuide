package com.limlab.kotlinsample

class Truck(private val id: Int, val name: String) {
    override fun equals(other: Any?): Boolean {
        val otherTruck = other as? Truck ?: return false

        return otherTruck.id == this.id

    }
}

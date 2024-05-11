package com.stc.conditionsinkotlin.exercises

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhones (var phoneIsScreenLightOn: Boolean) :
    Phone(isScreenLightOn = phoneIsScreenLightOn) {
        var isFolded: Boolean = true

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }

    override fun switchOn() {
        if (isFolded) {
            println("Foldable phone is not switched on.")
        } else {
            super.switchOn()
            println("Foldable phone switched on.")
        }
    }

}

fun main() {
    var foldablePhone = FoldablePhones(true)
    println("Phone's default (folded) state")
    foldablePhone.switchOn()
    println("")

    println("Phone unfolded state")
    foldablePhone.unfold()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
    println("")

    println("Phone is switched off")
    foldablePhone.switchOff()
    foldablePhone.checkPhoneScreenLight()
    println("")

    println("Phone folded")
    foldablePhone.fold()
    foldablePhone.switchOn()


}

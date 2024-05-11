package com.stc.conditionsinkotlin.exercises
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ConditionsInKotlin {
}

object Constants {
    const val STATUS_ON = true
    const val STATUS_OFF = false
}

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = Constants.STATUS_OFF
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = Constants.STATUS_ON
    }

    open fun turnOff() {
        deviceStatus = Constants.STATUS_OFF
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun decreaseVolume() {
        speakerVolume--
        println("Volume reduced to $speakerVolume")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number reduce to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if(smartTvDevice.deviceStatus != Constants.STATUS_ON) {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }

    fun turnOffTv() {
        if(smartTvDevice.deviceStatus == Constants.STATUS_ON) {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == Constants.STATUS_ON)
            smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == Constants.STATUS_ON)
            smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        if(smartLightDevice.deviceStatus != Constants.STATUS_ON) {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if(smartLightDevice.deviceStatus == Constants.STATUS_ON) {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == Constants.STATUS_ON)
            smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == Constants.STATUS_ON)
            smartLightDevice.decreaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartTvDevice.turnOn()

    var smartLightDevice = SmartLightDevice("Google Light", "Utility")
//    smartLightDevice.turnOn()

    var smartHome = SmartHome (smartTvDevice = smartTvDevice, smartLightDevice= smartLightDevice)
    println("Turn on count: ${smartHome.deviceTurnOnCount}")
    smartHome.turnOnTv()
    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.decreaseTvVolume()
    println("Turn on count: ${smartHome.deviceTurnOnCount}")
    smartHome.turnOffTv()

    smartHome.turnOnLight()
    smartHome.decreaseLightBrightness()
    smartHome.increaseLightBrightness()
    smartHome.turnOffLight()

    println("Turn on count: ${smartHome.deviceTurnOnCount}")
    smartHome.turnOffAllDevices()
    println("Turn on count: ${smartHome.deviceTurnOnCount}")
}

package com.stc.eventstracker.model

data class Event (
    val title : String,
    val description : String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
) {

}

fun main() {

    val spacing = "\n ------------------------------------------------------------------------------- \n"

    System.out.println(spacing)
    val event = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        Daypart.EVENING,
        15
        )
    System.out.println("Event (initial item): ${event.toString()}")


//    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    System.out.println(spacing)
//    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
//    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
//    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
//    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
//    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
//    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    val listEvents = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )
    System.out.println("Event lists (main): ${listEvents.toString()}")

//    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    System.out.println(spacing)
    val duration_for_short_event = 60
    val listEventsShort = listEvents.filter{
        it.durationInMinutes <= duration_for_short_event
    }
    System.out.println("")
    System.out.println("Short events: ${listEventsShort.toString()}")

//    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    System.out.println(spacing)
    val mapDaypartToCount = listEvents.groupBy {
        it.daypart
    }
    System.out.println("Events count by day-parts: ${mapDaypartToCount.toString()}")

    mapDaypartToCount.forEach {
        (daypart, events) ->
            println("$daypart: ${events.size} events")
    }

//    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    System.out.println(spacing)
    System.out.println("Last Event: ${listEvents.last().title}")

    //    -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    System.out.println(spacing)
    var firstEventDurationText = "short"
    if( listEvents.first().durationInMinutes > duration_for_short_event) {
        firstEventDurationText = "long"
    }
    System.out.println(
        "Duration of the first event of the day: ${firstEventDurationText}"
    )


}

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }


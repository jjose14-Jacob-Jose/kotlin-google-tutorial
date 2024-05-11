package com.stc.conditionsinkotlin.exercises

class SongCatalog (
    val title: String? = null,
    val artist: String? = null,
    val yearPublished: Int? = null,
    val playCount: Int? = null,

) {
    val isPopular: Boolean
        get() {
            return (playCount ?: 0) >= 1000
//        (playCount ?: 0) : if playCount is null, return 0; else return value of playCount
        }

     fun printDescription() {
         println("$title, performed by $artist, was released in $yearPublished.")
         if(isPopular)
             println("Is popular")
         else
             println("Is unpopular")
     }
}

fun main() {
    val songCatalogA = SongCatalog("Quit Playing Games with my heart", "Backstreet Boys", 1990, 10000)
    val songCatalogB = SongCatalog("Get Down, get down", "Backstreet Boys", 1991, 100)

    songCatalogA.printDescription()
    songCatalogB.printDescription()


}
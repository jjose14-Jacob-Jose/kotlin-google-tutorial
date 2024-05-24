package com.stc.courses.utility

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class Utility {
    companion object {
        @Composable
        fun convertDrawableIdStringToInt(imageIdString: String): Int {
            val context = LocalContext.current.applicationContext // Get the application context
            val imageResourceIdInt = context.resources.getIdentifier(
                imageIdString,
                "drawable",
                context.packageName
            )
            return imageResourceIdInt
        }
    }
}
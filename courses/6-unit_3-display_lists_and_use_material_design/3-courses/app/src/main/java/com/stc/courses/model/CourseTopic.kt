package com.stc.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val nameResourceId: Int,
    val associatedCoursesCount: Int,
    @DrawableRes val imageResourceId: Int
)

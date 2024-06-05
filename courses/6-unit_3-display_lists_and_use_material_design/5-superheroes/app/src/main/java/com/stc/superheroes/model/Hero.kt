package com.stc.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * A data class to represent the information presented in the hero card.
 */
data class Hero (
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes var imageRes: Int
)
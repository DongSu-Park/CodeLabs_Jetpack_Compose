package kr.dev.dspark.affirmation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResId : Int,
    @DrawableRes val imgResId : Int
)
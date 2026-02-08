package com.fadi.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtSpace(
    @DrawableRes val imageId: Int,
    @StringRes val titleId: Int,
    @StringRes val authorId: Int,
    @StringRes val yearId: Int,
)
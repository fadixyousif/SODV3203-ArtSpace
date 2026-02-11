package com.fadi.artspace.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.fadi.artspace.R

// Create data class
data class ArtSpace(
    @DrawableRes val imageId: Int,
    @StringRes val titleId: Int,
    @StringRes val authorId: Int,
    @StringRes val yearId: Int,
)

// Prepare artworks
val arts = listOf<ArtSpace>(
    ArtSpace(R.drawable.improvisation31, R.string.improvisation_full_title, R.string.improvisation_artist, R.string.improvisation_year),
    ArtSpace(R.drawable.george, R.string.george_full_title, R.string.george_artist, R.string.george_year),
    ArtSpace(R.drawable.girl, R.string.girl_full_title, R.string.girl_artist, R.string.girl_year)
)
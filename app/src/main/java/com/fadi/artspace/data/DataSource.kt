package com.fadi.artspace.data

import com.fadi.artspace.R
import com.fadi.artspace.model.ArtSpace

class DataSource {
    fun loadArt(): List<ArtSpace> {
        return listOf<ArtSpace>(
            ArtSpace(R.drawable.improvisation31, R.string.improvisation_full_title, R.string.improvisation_artist, R.string.improvisation_year),
            ArtSpace(R.drawable.george, R.string.george_full_title, R.string.george_artist, R.string.george_year),
            ArtSpace(R.drawable.girl, R.string.girl_full_title, R.string.girl_artist, R.string.girl_year)
        )
    }
}
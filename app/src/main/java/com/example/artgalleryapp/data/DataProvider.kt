package com.example.artgalleryapp.data

import com.example.artgalleryapp.R

object DataProvider {

    /**
     * Создает данные с картинками
     */
    fun createListOfArtObjects(): List<ArtObject> =
        listOf(
            ArtObject(
                imageId = R.drawable.bear,
                imageDescriptionId = R.string.bear_description,
                authorId = R.string.author_Ivan
            ),
            ArtObject(
                imageId = R.drawable.moose,
                imageDescriptionId = R.string.moose_description,
                authorId = R.string.author_Ivan
            ),
            ArtObject(
                imageId = R.drawable.daisy_in_mountain,
                imageDescriptionId = R.string.daisy_description,
                authorId = R.string.author_Petr
            ),
            ArtObject(
                imageId = R.drawable.river_in_siberia,
                imageDescriptionId = R.string.river_description,
                authorId = R.string.author_Petr
            ),
            ArtObject(
                imageId = R.drawable.fog,
                imageDescriptionId = R.string.fog_description,
                authorId = R.string.author_John
            ),
            ArtObject(
                imageId = R.drawable.winter_in_siberia,
                imageDescriptionId = R.string.winter_description,
                authorId = R.string.author_John
            )
        )
}
package com.example.artgalleryapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Данные о картинке
 *
 * @property imageId id картинки
 * @property imageDescriptionId строковое id описания
 * @property authorId строковое id автора картинки
 * @property year год создания картинки (всегда после 1989 года)
 */
data class ArtObject(
    @DrawableRes
    val imageId: Int,
    @StringRes
    val imageDescriptionId: Int,
    @StringRes
    val authorId: Int,
    val year: Int = (1990..2024).random()
)

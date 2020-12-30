package id.ac.amikom.apppanas.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
        val idCategory: String = "",
        val strCategory: String = "",
        val strCategoryThumb: String = "",
        val strCategoryDescription: String = ""
): Parcelable


package com.example.cocktailtest.data.models

import android.os.Parcel
import com.example.cocktailtest.extensions.parcelableCreator
import com.example.cocktailtest.utils.Parcelize
import com.google.gson.annotations.SerializedName

/**
 * Created by Artem on 25.04.2019.
 * company - A2Lab
 */

data class DrinkModel(
    @SerializedName("idDrink")
    override val id: Int = -1,
    @SerializedName("strDrink")
    val title: String,
    @SerializedName("strDrinkThumb")
    val image: String,
    var cocktailType: String? = null
): DrinkItem(), Parcelize {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeString(cocktailType)
    }

    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::DrinkModel)
    }
}
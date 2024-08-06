package com.example.snapfoodtask.model

import android.os.Parcel
import android.os.Parcelable

data class Person(
    val id: Int,
    val name: String,
    val birth_year: String,
    val height: String,
    val species: List<String>,
    val homeworld: String,
    val films: List<String>
): Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString() ?: "",
        birth_year = parcel.readString() ?: "",
        height = parcel.readString() ?: "",
        species = parcel.createStringArrayList() ?: emptyList() ,
        homeworld = parcel.readString() ?: "",
        films = parcel.createStringArrayList() ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(birth_year)
        parcel.writeString(height)
        parcel.writeStringList(species)
        parcel.writeString(homeworld)
        parcel.writeStringList(films)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
    }
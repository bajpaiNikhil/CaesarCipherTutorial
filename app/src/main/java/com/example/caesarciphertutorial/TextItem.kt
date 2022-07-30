package com.example.caesarciphertutorial

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TextItem(
    val key : Int ,
    val text : String
) : Parcelable

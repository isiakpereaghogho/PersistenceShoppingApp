package com.aghogho.week6app

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor

@Entity
data class ShoppingModel(
      val category: String,
    val description: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)


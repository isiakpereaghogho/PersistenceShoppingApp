package com.aghogho.week6app

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ShoppingModel::class),
    version = 1)

abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDAO

}
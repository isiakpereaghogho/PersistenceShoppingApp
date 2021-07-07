package com.aghogho.week6app

import androidx.lifecycle.ViewModel

class ShoppingViewModel: ViewModel() {
    fun addShoppingItem(
        shoppingItem: ShoppingModel,
        database: ShoppingDatabase){
        database.shoppingDao()
    }
}
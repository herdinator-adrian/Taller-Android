package com.example.aplicaciontaller.Data.model

import androidx.room3.Entity

//@Entity(tableName = )
data class CartProduct(
    val productId: Product,
    val quantity: Int,
)
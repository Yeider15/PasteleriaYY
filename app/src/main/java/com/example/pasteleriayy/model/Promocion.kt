package com.example.pasteleriayy.model

import androidx.annotation.DrawableRes

data class Promocion(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val fechaFin: String,
    val precio: Double,
    @DrawableRes val imagenResId: Int
)
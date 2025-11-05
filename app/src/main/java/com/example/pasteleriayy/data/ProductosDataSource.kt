package com.example.pasteleriayy.data

import com.example.pasteleriayy.R
import com.example.pasteleriayy.model.Producto

object ProductosDataSource {

    fun getListaProductos(): List<Producto> = listOf(
        Producto("TC001", "Torta Cuadrada de Chocolate",
            "Deliciosa torta de chocolate con capas de ganache...",
            45000.0, R.drawable.tc001),

        Producto("TC002", "Torta Cuadrada de Frutas",
            "Una mezcla de frutas frescas y crema chantilly...",
            50000.0, R.drawable.tc002),

        Producto("TT001", "Torta Circular de Vainilla",
            "Bizcocho de vainilla clásico relleno con crema...",
            40000.0, R.drawable.tt001)
    )
}
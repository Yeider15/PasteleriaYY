package com.example.pasteleriayy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pasteleriayy.R
import com.example.pasteleriayy.model.Producto

class MenuViewModel : ViewModel() {


    private val _productos = MutableLiveData<List<Producto>>()
    val productos: LiveData<List<Producto>> get() = _productos

    init {
        cargarDatos()
    }

    fun cargarDatos() {
        val listaProductos = listOf(
            Producto(
                id = "TC001",
                nombre = "Torta Cuadrada de Chocolate",
                descripcion = "Deliciosa torta de chocolate con capas de ganache y un toque de avellanas. Personalizable con mensajes especiales.",
                precio = 45000.0,
                imagenResId = R.drawable.tc001
            ),
            Producto(
                id = "TC002",
                nombre = "Torta Cuadrada de Frutas",
                descripcion = "Una mezcla de frutas frescas y crema chantilly sobre un suave bizcocho de vainilla, ideal para celebraciones.",
                precio = 50000.0,
                imagenResId = R.drawable.tc002
            ),
            Producto(
                id = "TT001",
                nombre = "Torta Circular de Vainilla",
                descripcion = "Bizcocho de vainilla clásico relleno con crema pastelera y cubierto con un glaseado dulce, perfecto para cualquier ocasión.",
                precio = 40000.0,
                imagenResId = R.drawable.tc001 // Ejemplo de reutilización
            )
        )

        // Asigna la lista al LiveData
        _productos.value = listaProductos


    }

    fun getProductoById(id: String): Producto? {
        // Utilizamos el valor actual de LiveData para buscar
        return _productos.value?.find { it.id == id }
    }
}
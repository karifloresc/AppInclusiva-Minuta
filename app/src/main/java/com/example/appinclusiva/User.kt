package com.example.appinclusiva

/**
 * Reemplazado por com.example.appinclusiva.data.model.Usuario
 * No usar en nuevas pantallas.
 */
@Deprecated("Usar Usuario (data.model)")
data class User(
    val nombre: String,
    val email: String,
    val metodoComunicacion: String,
    val letraGrande: Boolean,
    val altoContraste: Boolean,
    val tamanoTexto: String
)

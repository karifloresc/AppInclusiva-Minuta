package com.example.appinclusiva.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.example.appinclusiva.data.model.Usuario

object UsuariosRepository {

    // SnapshotStateList: si agregas desde Register, las pantallas que lo lean se actualizan solas.
    private val usuarios = mutableStateListOf(
        Usuario("User1", "user1@mail.com", "1234"),
        Usuario("User2", "user2@mail.com", "1234"),
        Usuario("User3", "user3@mail.com", "1234"),
        Usuario("User4", "user4@mail.com", "1234"),
        Usuario("User5", "user5@mail.com", "1234")
    )

    fun registrar(usuario: Usuario): Boolean {
        if (usuarios.any { it.email.equals(usuario.email, ignoreCase = true) }) return false
        usuarios.add(usuario)
        return true
    }

    fun buscarPorEmail(email: String): Usuario? =
        usuarios.find { it.email.equals(email, ignoreCase = true) }

    fun obtenerUsuarios(): List<Usuario> = usuarios
}

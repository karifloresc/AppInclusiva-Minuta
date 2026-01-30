package com.example.appinclusiva.ui.theme

import androidx.compose.ui.graphics.Color

// 🎨 Color base de la app
val GreenPrimary = Color(0xFF032A28)

// ---------- MODO CLARO ----------
val Primary = GreenPrimary
val OnPrimary = Color.White

val Secondary = Color(0xFF000000) // amarillo cálido claro (para links y acentos)
val OnSecondary = Color(0xFF2B2B2B)

val BackgroundLight = Color(0xFFFFFFFF)      // fondo blanco
val SurfaceLight = Color(0xFFF7F9F9)         // blanco suave (cards, inputs)

val TextDark = Color(0xFF1C1C1C)
val OutlineLight = GreenPrimary              // bordes verdes

// ---------- MODO OSCURO ----------
val BackgroundDark = Color(0xFF020B0A) // fondo oscuro verde
val SurfaceDark = Color(0xFF0B2F2B)           // verde un poco más claro

val TextLight = Color(0xFFEFEFEF)
val OutlineDark = Color(0xFFB9ECBA)           // verde suave para bordes

// ---------- ESTADOS ----------
val Error = Color(0xFFD32F2F)

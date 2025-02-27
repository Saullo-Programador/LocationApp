package com.example.locationapp.ui.features.format

fun formatCep(cep: String?): String {
    if (cep.isNullOrBlank() || !cep.all { it.isDigit() }) return cep ?: "Não informado"

    val cleanedCep = cep.filter { it.isDigit() } // Remove qualquer caractere não numérico
    return if (cleanedCep.length > 5) {
        "${cleanedCep.substring(0, 5)}-${cleanedCep.substring(5)}"
    } else {
        cleanedCep
    }
}

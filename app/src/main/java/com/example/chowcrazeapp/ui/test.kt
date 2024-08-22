package com.example.chowcrazeapp.ui

class Libro(val titulo: String, val autor: String) {
    var disponible: Boolean = true
}

class Miembro(val nombre: String, val apellido: String) {
    val librosPrestados: MutableList<Libro> = mutableListOf()
}

class Biblioteca {
    val libros: MutableList<Libro> = mutableListOf()
    val miembros: MutableList<Miembro> = mutableListOf()

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
    }

    fun agregarMiembro(miembro: Miembro) {
        miembros.add(miembro)
    }

    fun prestarLibro(libro: Libro, miembro: Miembro) {
        if (libro.disponible) {
            libro.disponible = false
            miembro.librosPrestados.add(libro)
            println("${libro.titulo} ha sido prestado a ${miembro.nombre} ${miembro.apellido}.")
        } else {
            println("El libro ${libro.titulo} no está disponible para prestar.")
        }
    }

    fun devolverLibro(libro: Libro, miembro: Miembro) {
        if (miembro.librosPrestados.contains(libro)) {
            miembro.librosPrestados.remove(libro)
            libro.disponible = true
            println("${libro.titulo} ha sido devuelto por ${miembro.nombre} ${miembro.apellido}.")
        } else {
            println("El libro ${libro.titulo} no fue prestado por ${miembro.nombre} ${miembro.apellido}.")
        }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("El señor de los anillos", "J.R.R. Tolkien")
    val libro2 = Libro("Cien años de soledad", "Gabriel García Márquez")
    val libro3 = Libro("Don Quijote de la Mancha", "Miguel de Cervantes")

    biblioteca.agregarLibro(libro1)
    biblioteca.agregarLibro(libro2)
    biblioteca.agregarLibro(libro3)

    val miembro1 = Miembro("Juan", "Pérez")
    val miembro2 = Miembro("María", "González")

    biblioteca.agregarMiembro(miembro1)
    biblioteca.agregarMiembro(miembro2)

    biblioteca.prestarLibro(libro1, miembro1)
    biblioteca.prestarLibro(libro2, miembro2)

    biblioteca.devolverLibro(libro1, miembro1)
}
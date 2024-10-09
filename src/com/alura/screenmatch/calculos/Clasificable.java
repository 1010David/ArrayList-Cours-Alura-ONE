package com.alura.screenmatch.calculos;

// La interfaz Clasificable define un contrato para cualquier clase que implemente
// la interfaz, obligándola a proporcionar una implementación para el método getClasificacion.
public interface Clasificable {

    // Método que debe ser implementado por las clases que implementen esta interfaz.
    // Este método devuelve un entero que representa la clasificación del objeto.
    int getClasificacion();
}

package com.alura.screenmatch.calculos;

import com.alura.screenmatch.modelos.Titulo;

// La clase CalculadoraDeTiempo se encarga de calcular y almacenar el tiempo total
// de duración de títulos (películas o series).
public class CalculadoraDeTiempo {

    // Atributo que almacena el tiempo total acumulado en minutos.
    private int tiempoTotal;

    // Método que devuelve el tiempo total acumulado.
    public int getTiempoTotal() {
        return this.tiempoTotal;
    }

    // Método que agrega la duración de un título al tiempo total.
    // Este método se ha sobrecargado para aceptar objetos de tipo Filme y Serie, pero
    // actualmente está comentado.
    /*
    public void incluido(Filme f) {
        this.tiempoTotal += f.getDuracionEnMinutos();
    }

    public void incluido(Serie s) {
        this.tiempoTotal += s.getDuracionEnMinutos();
    }
    */

    // Método que agrega la duración de un título genérico al tiempo total.
    // Acepta cualquier objeto que extienda de Titulo.
    public void incluido(Titulo titulo) {
        // Imprime en consola el título que se está agregando al tiempo total.
        System.out.println("Agregando duración en minutos de " + titulo);
        // Suma la duración en minutos del título al tiempo total.
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }
}

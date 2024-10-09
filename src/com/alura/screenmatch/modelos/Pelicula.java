package com.alura.screenmatch.modelos;

// Importa la interfaz Clasificable que se utilizará para la clasificación de películas.
import com.alura.screenmatch.calculos.Clasificable;

// La clase Pelicula representa una película, extendiendo la clase Titulo e implementando la interfaz Clasificable.
public class Pelicula extends Titulo implements Clasificable {

    // Atributo que almacena el director de la película.
    private String director;

    // Constructor de la clase Pelicula que inicializa el nombre y la fecha de lanzamiento mediante el constructor de la clase padre Titulo.
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    // Método que devuelve el nombre del director de la película.
    public String getDirector() {
        return director;
    }

    // Método que establece el nombre del director de la película.
    public void setDirector(String director) {
        this.director = director;
    }

    // Método que implementa la lógica de clasificación definida en la interfaz Clasificable.
    @Override
    public int getClasificacion() {
        // Retorna la clasificación calculando la media de evaluaciones y dividiéndola por 2.
        return (int) calculaMediaEvaluaciones() / 2;
    }

    // Método que devuelve una representación en forma de cadena de la película, incluyendo su nombre y fecha de lanzamiento.
    @Override
    public String toString() {
        return "Pelicula: " + this.getNombre() + "(" + getFechaDeLanzamiento() + ")";
    }
}

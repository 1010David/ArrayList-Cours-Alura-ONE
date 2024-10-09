package com.alura.screenmatch.modelos;

// Importa la interfaz Clasificable que se utilizará para la clasificación de episodios.
import com.alura.screenmatch.calculos.Clasificable;

// La clase Episodio representa un episodio de una serie, implementando la interfaz Clasificable.
public class Episodio implements Clasificable {

    // Atributo que almacena el número del episodio.
    private int numero;

    // Atributo que almacena el nombre del episodio.
    private String nombre;

    // Atributo que referencia la serie a la que pertenece este episodio.
    private Serie serie;

    // Atributo que almacena el total de visualizaciones del episodio.
    private int totalVisualizaciones;

    // Método que devuelve el total de visualizaciones del episodio.
    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    // Método que establece el total de visualizaciones del episodio.
    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    // Método que devuelve el número del episodio.
    public int getNumero() {
        return numero;
    }

    // Método que establece el número del episodio.
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Método que devuelve el nombre del episodio.
    public String getNombre() {
        return nombre;
    }

    // Método que establece el nombre del episodio.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método que devuelve la serie a la que pertenece este episodio.
    public Serie getSerie() {
        return serie;
    }

    // Método que establece la serie a la que pertenece este episodio.
    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    // Método que implementa la lógica de clasificación definida en la interfaz Clasificable.
    @Override
    public int getClasificacion() {
        // Retorna la clasificación basada en el total de visualizaciones.
        if (totalVisualizaciones > 100) {
            return 4; // Clasificación alta si las visualizaciones son mayores a 100.
        } else {
            return 2; // Clasificación baja en caso contrario.
        }
    }
}

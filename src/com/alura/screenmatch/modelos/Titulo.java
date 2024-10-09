package com.alura.screenmatch.modelos;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

// La clase Titulo representa una película o serie y es comparable con otras instancias de Titulo.
public class Titulo implements Comparable<Titulo> {

    // Atributo que almacena el nombre de la película o serie.
    @SerializedName("Title")
    private String nombre;

    // Atributo que almacena el año de lanzamiento de la película o serie.
    @SerializedName("Year")
    private int fechaDeLanzamiento;

    // Atributo que indica si el título está incluido en el plan de suscripción.
    private boolean incluidoEnElPlan;

    // Atributo que acumula la suma de todas las evaluaciones del título.
    private double sumaDeLasEvaluaciones;

    // Atributo que almacena el total de evaluaciones realizadas para el título.
    private int totalDeEvaluaciones;

    // Atributo que almacena la duración del título en minutos.
    private int duracionEnMinutos;

    // Constructor que inicializa el nombre y la fecha de lanzamiento del título.
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    // Constructor que crea un Titulo a partir de un objeto TitulboOmd.
    public Titulo(TitulboOmd miTituloOmbd) {
        this.nombre = miTituloOmbd.title(); // Inicializa el nombre.
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmbd.year()); // Inicializa la fecha de lanzamiento.

        // Verifica si la duración es N/A y lanza una excepción si es el caso.
        if (miTituloOmbd.runtime().contains("N/A")) {
            throw new ErrorEnConversionDeDuracionException("No se pudo convertir la duracion"
                    + " Contiene N/A.");
        }

        // Extrae la duración en minutos del string y la asigna al atributo correspondiente.
        this.duracionEnMinutos = Integer.valueOf(miTituloOmbd.runtime()
                .substring(0, 3).replace(" ", "")
        );
    }

    // Método que devuelve el nombre del título.
    public String getNombre() {
        return nombre;
    }

    // Método que devuelve la fecha de lanzamiento.
    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    // Método que indica si el título está incluido en el plan.
    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    // Método que devuelve la duración en minutos del título.
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    // Método que devuelve el total de evaluaciones realizadas.
    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    // Método que establece el nombre del título.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método que establece la fecha de lanzamiento.
    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    // Método que establece si el título está incluido en el plan.
    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    // Método que establece la duración en minutos del título.
    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    // Método que muestra la ficha técnica del título en consola.
    public void muestraFichaTecnica() {
        System.out.println("Nombre de la película: " + nombre);
        System.out.println("Año de lanzamiento: " + fechaDeLanzamiento);
    }

    // Método que permite evaluar el título con una nota.
    public void evalua(double nota) {
        sumaDeLasEvaluaciones += nota; // Suma la evaluación a la suma total.
        totalDeEvaluaciones++; // Incrementa el contador de evaluaciones.
    }

    // Método que calcula la media de las evaluaciones.
    public double calculaMediaEvaluaciones() {
        return sumaDeLasEvaluaciones / totalDeEvaluaciones; // Devuelve la media.
    }

    // Método que compara este título con otro basado en el nombre.
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    // Método que devuelve una representación en forma de cadena del título.
    @Override
    public String toString() {
        return "(nombre=" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", duracion=" + duracionEnMinutos + ")";
    }
}

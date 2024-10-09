package com.alura.screenmatch.principal;

import com.alura.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.modelos.Episodio;
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        // Se crea una instancia de Pelicula con el nombre "Encanto" y año 2021.
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        // Se establece la duración de la película en minutos.
        miPelicula.setDuracionEnMinutos(180);
        // Se imprime la duración de la película.
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

        // Se muestra la ficha técnica de la película.
        miPelicula.muestraFichaTecnica();
        // Se evalúa la película con varias notas.
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        // Se imprime el total de evaluaciones realizadas a la película.
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        // Se calcula y se imprime la media de las evaluaciones.
        System.out.println(miPelicula.calculaMediaEvaluaciones());

        // Se crea una instancia de Serie con el nombre "Lost" y año 2000.
        Serie lost = new Serie("Lost", 2000);
        // Se muestra la ficha técnica de la serie.
        lost.muestraFichaTecnica();
        // Se establecen los atributos de la serie.
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        // Se imprime la duración total de la serie en minutos.
        System.out.println("Duracion de la serie: " + lost.getDuracionEnMinutos());

        // Se crea otra película "Avatar" de 2023 y se establece su duración.
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.setDuracionEnMinutos(200);

        // Se crea una instancia de CalculadoraDeTiempo para calcular el tiempo total.
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        // Se agregan las películas y la serie a la calculadora para sumar sus duraciones.
        calculadora.incluido(miPelicula);
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);
        // Se imprime el tiempo total acumulado.
        System.out.println(calculadora.getTiempoTotal());

        // Se crea una instancia de FiltroRecomendacion para evaluar títulos.
        FiltroRecomendacion filtro = new FiltroRecomendacion();
        // Se filtra la película para obtener recomendaciones.
        filtro.filtra(miPelicula);

        // Se crea un episodio de la serie "Lost".
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        // Se filtra el episodio para obtener recomendaciones.
        filtro.filtra(episodio);

        // Se crea otra película "El Sr De Los Anillos" y se establece su duración.
        Pelicula masPelicula = new Pelicula("El Sr De Los Anillos", 2001);
        masPelicula.setDuracionEnMinutos(180);

        // Se crea una lista para almacenar películas.
        ArrayList<Pelicula> listaDePelis = new ArrayList<>();
        // Se agregan las películas a la lista.
        listaDePelis.add(masPelicula);
        listaDePelis.add(miPelicula);
        listaDePelis.add(otraPelicula);

        // Se imprime el tamaño de la lista de películas.
        System.out.println("Tamaño de la lista: " + listaDePelis.size());
        // Se imprime el nombre de la primera película en la lista.
        System.out.println("La primera película es: " + listaDePelis.get(0).getNombre());
        // Se imprime la lista de películas.
        System.out.println(listaDePelis);
        // Se imprime la representación en forma de cadena de la primera película.
        System.out.println("toString de la película: " + listaDePelis.get(0).toString());
    }
}

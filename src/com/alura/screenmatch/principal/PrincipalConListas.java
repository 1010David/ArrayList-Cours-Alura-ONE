package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {

    public static void main(String[] args) {
        // Se crean instancias de Pelicula y se evalúan con calificaciones.
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(6);

        Pelicula masPelicula = new Pelicula("El Sr De Los Anillos", 2001);
        masPelicula.evalua(10);

        // Se crea una instancia de Serie.
        Serie lost = new Serie("Lost", 2000);

        // Se crea una lista para almacenar objetos de tipo Titulo (Pelicula y Serie).
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(masPelicula);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);

        // Se itera sobre la lista para imprimir los nombres y clasificaciones de las películas.
        for (Titulo item : lista) {
            System.out.println(item.getNombre()); // Imprime el nombre del título.
            // Verifica si el título es una película y si su clasificación es mayor que 2.
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println(pelicula.getClasificacion()); // Imprime la clasificación.
            }
        }

        // Se crea una lista de artistas.
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Rin");
        System.out.println(listaDeArtistas); // Imprime la lista de artistas.

        // Se ordena la lista de artistas alfabéticamente.
        Collections.sort(listaDeArtistas);
        System.out.println("Lista ordenada: " + listaDeArtistas); // Imprime la lista ordenada.

        // Se intenta ordenar la lista de títulos (puede requerir un método toString en Titulo).
        Collections.sort(lista);
        System.out.println("Lista Títulos ordenada: " + lista); // Imprime la lista de títulos ordenada.

        // Se ordena la lista de títulos por fecha de lanzamiento.
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada: " + lista); // Imprime la lista de títulos ordenada por fecha de lanzamiento.
    }
}

package com.alura.screenmatch.calculos;

// La clase FiltroRecomendacion se encarga de proporcionar recomendaciones
// basadas en la clasificación de los títulos que implementan la interfaz Clasificable.
public class FiltroRecomendacion {

    // Atributo que almacena la recomendación, aunque actualmente no se utiliza.
    private String recomendacion;

    // Método que recibe un objeto de tipo Clasificable y filtra las recomendaciones
    // basándose en su clasificación.
    public void filtra(Clasificable clasificable) {
        // Si la clasificación es 4 o superior, se considera uno de los favoritos.
        if (clasificable.getClasificacion() >= 4) {
            System.out.println("Está entre los favoritos del momento");
            // Si la clasificación es entre 2 y 3, se indica que está bien evaluado.
        } else if (clasificable.getClasificacion() >= 2) {
            System.out.println("Bien evaluado actualmente");
            // Para clasificaciones menores a 2, se sugiere agregarlo a la lista para verlo después.
        } else {
            System.out.println("Colocalo en tu lista para verlo después");
        }
    }
}

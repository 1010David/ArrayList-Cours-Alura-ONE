package com.alura.screenmatch.modelos;

// La clase Serie representa una serie de televisión, extendiendo la clase Titulo.
public class Serie extends Titulo {

    // Atributo que almacena el número de temporadas de la serie.
    private int temporadas;

    // Atributo que indica si la serie está activa (en producción o no).
    private boolean activa;

    // Atributo que almacena el número de episodios por temporada.
    private int episodiosPorTemporada;

    // Atributo que almacena la duración en minutos de cada episodio.
    private int minutosPorEpisodio;

    // Constructor de la clase Serie que inicializa el nombre y la fecha de lanzamiento mediante el constructor de la clase padre Titulo.
    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    // Método que devuelve el número de temporadas de la serie.
    public int getTemporadas() {
        return temporadas;
    }

    // Método que establece el número de temporadas de la serie.
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Método que devuelve si la serie está activa.
    public boolean isActiva() {
        return activa;
    }

    // Método que establece el estado activo de la serie.
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    // Método que devuelve el número de episodios por temporada.
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    // Método que establece el número de episodios por temporada.
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    // Método que devuelve la duración en minutos de cada episodio.
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    // Método que establece la duración en minutos de cada episodio.
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    // Método que devuelve la duración total de la serie en minutos, calculando el total de episodios multiplicado por la duración de cada uno.
    @Override
    public int getDuracionEnMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    // Método que devuelve una representación en forma de cadena de la serie, incluyendo su nombre y fecha de lanzamiento.
    public String toString(){
        return "Serie: " + this.getNombre() + "(" + this.getFechaDeLanzamiento() + ")";
    }
}

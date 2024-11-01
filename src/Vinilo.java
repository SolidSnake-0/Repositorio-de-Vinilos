package src;

public class Vinilo {
    private String artista;
    private String titulo;
    private int añoLanzamiento;

    public Vinilo(String artista, String titulo, int añoLanzamiento) {
        this.artista = artista;
        this.titulo = titulo;
        this.añoLanzamiento = añoLanzamiento;
    }

    public String getArtista() {
        return artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }


    }


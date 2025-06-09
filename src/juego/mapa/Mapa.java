package juego.mapa;

import juego.personajes.Personaje;

public class Mapa {

    private int filas;
    private int columnas;
    private Celda[][] celdas;

    //constructor, se crea el mapa con las dimensiones dadas
    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[filas][columnas];

        //llenamos cada celda con una instancia vacia
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    //devolvemos la celda en la posicion indicada
    public Celda getCelda(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            return celdas[x][y];
        }
        return null;
    }

    
    //colocamos un personaje en su posicion inicial
    public void colocarPersonaje(Personaje nuevoPersonaje){
        
    }
}

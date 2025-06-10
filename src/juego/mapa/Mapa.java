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
                celdas[i][j] = new Celda(); //usamos el constructor vacio
            }
        }
    }

    //devolvemos la celda en la posicion indicada
    public Celda getCelda(int x, int y) {
        if ((x >= 0 && x < filas) && (y >= 0 && y < columnas)) {
            return celdas[x][y];
        }
        return null; //si esta fuera del mapa
    }

    //colocamos un personaje en su posicion inicial
    public void colocarPersonaje(Personaje nuevoPersonaje) {
        //buscamos las posiciones del personaje
        int x = nuevoPersonaje.getPosicion().getX();
        int y = nuevoPersonaje.getPosicion().getY();

        Celda celda = getCelda(x, y);

        //verificamos que la celda este libre, antes de usarla
        if (celda != null && celda.estaLibre()) {
            celda.setPersonaje(nuevoPersonaje);
        }
    }

    //movemos un personaje de una celda a otra
    public void moverPersonaje(Personaje personaje, int nuevoX, int nuevoY) {
        //obtenemos la posicion actual del personaje
        int xActual = personaje.getPosicion().getX();
        int yActual = personaje.getPosicion().getY();

        //obtenemos las celdas actuales y las de destino
        Celda origen = getCelda(xActual, yActual);
        Celda destino = getCelda(nuevoX, nuevoY);

        if (destino != null && destino.estaLibre()) {
            origen.setPersonaje(null); //sacamos el personaje de la celda actual
            destino.setPersonaje(personaje); //ponemos el personaje en la nueva celda
            personaje.setPosicion(new Posicion(nuevoX, nuevoY)); //actualizamos la posicion
        } else {
            System.out.println("Movimiento invalido: celda ocupada o fuera del mapa");
        }

    }

    public void mostrar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; i < columnas; j++) {
                Celda celda = celdas[i][j];

                if (celda.getPersonaje() != null) {
                    System.out.print("P "); //personaje presente
                } else if (celda.getObjeto() != null) {
                    System.out.print("O "); //objeto presente
                } else if (celda.isPuertaBloqueda()) {
                    System.out.print("X "); //puerta cerrada
                } else {
                    System.out.print(". "); //celda vacia
                }
            }
        }
    }
}

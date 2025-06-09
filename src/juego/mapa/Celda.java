package juego.mapa;

import juego.objetos.Objeto;
import juego.personajes.Personaje;

public class Celda {

    private Personaje personaje; // pueder ser Snake, Guardia o MetalGear
    private Objeto objeto; // puede ser Tarjeta, C4, etc
    private boolean puertaBloqueada; //true si esta cerrada, false si esta abierta

    //constructor vacio, se inicia con todas las celdas vacias
    public Celda() {
        this.personaje = null;
        this.objeto = null;
        this.puertaBloqueada = false;
    }

    //metodos para personaje
    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    //metodos para objeto
    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    //metodos para puerta bloqueada
    public boolean isPuertaBloqueda() {
        return puertaBloqueada;
    }

    public void setPuertaBloqueda(boolean puertaBloqueda) {
        this.puertaBloqueada = puertaBloqueda;
    }

    //metodo para saber si la celda esta vacia o no
    public boolean estaLibre() {
        return personaje == null && !puertaBloqueada;
    }
}

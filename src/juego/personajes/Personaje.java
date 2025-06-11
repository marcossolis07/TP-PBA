package juego.personajes;

import juego.mapa.Posicion;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected Posicion posicion;

    //constructor
    public Personaje(String nombre, int vida, Posicion posicion) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicion = posicion;
    }

    //metodo abstracto, cada personaje que implemente esta clase, tiene que implementar el metodo
    public abstract void mover();

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    //setters
    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    //metodo para recibir daño
    public void recibirDanio(int danio) {
        //restamos el daño recibido a la vida que tenemos
        this.vida -= danio;

        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    //metodo para saber si el personaje esta muerto
    public boolean estaMuerto() {
        return this.vida <= 0;
    }

}

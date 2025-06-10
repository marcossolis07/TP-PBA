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

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void recibirDanio(int danio) {
        //restamos el daño recibido a la vida que tenemos
        this.vida -= danio;

        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public boolean estaMuerto() {
        return this.vida <= 0;
    }

}

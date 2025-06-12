package juego.personajes;

import java.util.Random;
import juego.mapa.Mapa;
import juego.mapa.Posicion;
import juego.objetos.Objeto;

/*
Protagonista principal, se mueve, recoge objetos, y pelea
 */
public class Snake extends Personaje {

    private Random random; //para generar numeros aleatorios
    private boolean tieneTarjeta;
    private boolean tieneBomba; //seria el C4

    //constructor
    public Snake(String nombre, int vida, Posicion posicion) {
        super(nombre, vida, posicion);
        this.random = new Random();
        this.tieneTarjeta = false; //arranca en false porque todavia no tiene nada
        this.tieneBomba = false; //arranca en false porque todavia no tiene nada
    }

    @Override
    public void mover() {
        //por ahora no implementamos movimiento automatico porque no lo necesita
        //snake se movera por input desde el menu (se maneja manualmente)
        System.out.println(nombre + " espera órdenes");
    }

    //metodo atacar, para pelear contra MetalGear, daño aleatorio
    public int atacar() {
        int danio = random.nextInt(21) + 10; //el daño tiene que ser entre 10 y 30

        System.out.println(nombre + " disparó un misil e hizo " + danio + " de daño.");
        return danio;
    }

    //metedo esquivar, para reducir daño
    public int esquivar(int danioOriginal) {
        int reduccion = 50 + random.nextInt(51); //entre 50% y 100%
        int danioReducido = danioOriginal * (100 - reduccion) / 100;

        System.out.println(nombre + " esquivó. Se redujo el daño a " + danioReducido + " HP.");
        this.recibirDanio(danioReducido); //se aplica el daño recibido
        return danioReducido;
    }

    //metodo para recoger objetos
    public void recogerTarjeta() {
        this.tieneTarjeta = true;
        System.out.println("Recogiste la tarjeta de acceso.");
    }

    //metodo para recoger C4
    public void recogerBomba() {
        this.tieneBomba = true;
        System.out.println("Recogiste el C4.");
    }

    //metodos para verificar si tiene tarjeta o C4
    public boolean siTieneTarjeta() {
        return tieneTarjeta;
    }

    public boolean siTieneBomba() {
        return tieneBomba;
    }

}

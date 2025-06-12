package juego.personajes;

import juego.mapa.Posicion;
import java.util.Random;
import juego.mapa.Mapa;

public class Guardia extends Personaje implements Enemigo {

    /*lo que tiene q hacer guardia es:
    -patrullar
    -se mueve aleatoriamente en direcciones verticales y horizontales
    (nunca en diagonal)
    -si esta a 1 celda de distancia de Snake, lo detecta
    -si lo detecta, lo atrapa y se reinica la mision
    }
     */
    private final Random random = new Random(); //usamos para elegir direcciones al azar
    private Mapa mapa;

    //constructor
    public Guardia(String nombre, int vida, Posicion posicion, Mapa mapa) {
        super(nombre, vida, posicion);
        this.mapa = mapa;
    }

    @Override
    public boolean detectar(Snake snake) {
        //este metodo devuelve true si snake esta a 1 celda de distancia
        return this.posicion.estaCerca(snake.getPosicion(), 1);
    }

    @Override
    public int atacar(Snake snake) {
        if (this.detectar(snake)) {
            snake.setVida(0); // lo mata
            System.out.println("¡Un Guardia te capturo! Mision fallida.");
        }
        return this.getVida();
    }

    @Override
    public void mover() {
        patrullar(); // se mueve automaticamente, llamando a su logica
    }

    public void patrullar() {
        int movimiento = random.nextInt(4); // de 0 a 3

        //obtenemos la posicion actual
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();

        //se elige la direccion aleatoria
        switch (movimiento) {
            case 0:
                x -= 1;
                break; //arriba
            case 1:
                x += 1;
                break; //abajo
            case 2:
                y -= 1;
                break;  //izquierda
            case 3:
                y += 1;
                break;  //derecha   
        }

        //validamos si se puede mover a esa celda
        //primero nos fijamos si existe el lugar y despues si esta libre
        if (mapa.getCelda(x, y) != null && mapa.getCelda(x, y).estaLibre()) {
            mapa.moverPersonaje(this, x, y);
        } else {
            System.out.println(this.getNombre() + " no se pudo mover");
        }
    }

}

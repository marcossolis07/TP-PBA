
package juego.personajes;

import juego.mapa.Posicion;
import java.util.Random;
import juego.mapa.Mapa;

public class Guardia extends Personaje implements Enemigo{
    
    private Random random = new Random();

    public Guardia(String nombre, int vida, Posicion posicion) {
        super(nombre, vida, posicion);
    }

    @Override
    public boolean detectar(Snake snake) {
        return (snake.getPosicion().estaCerca(this.posicion, 1)); 
        }
        

    @Override
    public void atacar(Snake snake) {
        if(this.detectar(snake) == true){
        snake.setVida(0);
        System.out.println("¡Un Guardia te capturo! Mision fallida.");    
        }
    }

    @Override
    public void mover() {
        System.out.println("");
    }
    
    public void patrullar (Mapa mapa){
        int movimiento = random.nextInt(4);
        int x=0;
        int y=0;
        switch(movimiento){
            case 0: x= -1; break;
            case 1: x= +1; break;
            case 2: y= -1; break;  
            case 3: y= 1;  break;     
        }    
        mapa.moverPersonaje(this, x, y);
    }
    
}

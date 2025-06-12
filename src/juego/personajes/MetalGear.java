package juego.personajes;

import java.util.Random;
import juego.mapa.Posicion;

public class MetalGear extends Personaje implements Enemigo {

    private final int min = 15;
    private final int max = 40;
    private final Random random = new Random();

    public MetalGear(String nombre, int vida) {
        super(nombre, vida, null); // le paso null porque no necesita posicion
    }

    @Override
    public boolean detectar(Snake snake) {
        //siempre esta peleando con snake, asi que lo detecta
        return true;
    }

    @Override
    public void atacar(Snake snake) {
        //elegimos aleatoriamente si usa laser o msil
        if (random.nextBoolean()) {
            atacarLaser(snake);
        } else {
            atacarMisil(snake);
        }
    }

    public void atacarMisil(Snake snake) {
        int ataque = min + random.nextInt(max - min + 1);
        snake.recibirDanio(ataque);
        System.out.println("¡Metal Gear ataca con un Misil! (-" + ataque + " HP)\n");
    }

    public void atacarLaser(Snake snake) {
        int ataque = min + random.nextInt(max - min + 1);
        snake.recibirDanio(ataque);
        System.out.println("¡Metal Gear ataca con un Canion Laser! (-" + ataque + " HP)\n");
    }

    @Override
    public void mover() {
        //no se mueve en el mapa
    }

}

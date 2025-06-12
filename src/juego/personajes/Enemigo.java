package juego.personajes;

public interface Enemigo {

    boolean detectar(Snake snake);

    int atacar(Snake snake);

}

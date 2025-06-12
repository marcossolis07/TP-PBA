
package juego.misiones;

import juego.personajes.Snake;


public class MisionFinal extends Mision{

    public MisionFinal(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public boolean iniciar(Snake snake) {
        System.out.println("Mision Final......");
        return false;
    }
    
}

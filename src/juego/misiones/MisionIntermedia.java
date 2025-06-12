
package juego.misiones;
import juego.personajes.*;

public class MisionIntermedia extends Mision{
    private int numMision;

    public MisionIntermedia(String nombre, String descripcion, int mision) {
        super(nombre, descripcion);
        this.numMision = mision;
    }
    
    @Override
    public boolean iniciar(Snake snake) {
        switch (numMision){
            case 0: System.out.println("Mision 1"); 
                return hangar(snake);
            case 1: System.out.println("Mision 2"); 
                return almacen(snake);
    }
        return false;
} 

    private boolean hangar(Snake snake) {
        
        System.out.println("Iniciando Mision: " + this.nombre.toUpperCase() + " " + this.descripcion);
        

        return this.misionCompletada;

    }
    
    private boolean almacen(Snake snake){
        System.out.println("Iniciando Mision: " + this.nombre.toUpperCase() + " " + this.descripcion);
        
        return this.misionCompletada;
    }
}

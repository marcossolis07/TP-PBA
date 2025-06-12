
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
                
                break;
            case 1: System.out.println("Mision 2"); 
                break;
        
        //System.out.println("Iniciando Mision: " + this.nombre + " " + this.descripcion);
    }
        return false;
} 
}

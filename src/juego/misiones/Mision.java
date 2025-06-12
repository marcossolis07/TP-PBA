
package juego.misiones;
import juego.personajes.Snake;

public abstract class Mision{
    public boolean misionCompletada;
    public String nombre;
    public String descripcion;
    
    public Mision(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.misionCompletada = false;
    }

    public boolean isMisionCompletada() {
        return misionCompletada;
    }

    public void setMisionCompletada(boolean misionCompletada) {
        this.misionCompletada = misionCompletada;
    }
    
    
    public abstract boolean iniciar(Snake snake);
    
    
}


package juego.misiones;
import juego.Juego;

public abstract class Mision extends Juego {
    public boolean misionCompletada;
    public String nombre;
    public String descripcion;
    
    public Mision(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.misionCompletada = false;
    }
    
    @Override
    public abstract void iniciar();
    
    
}

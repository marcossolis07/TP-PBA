
package juego.misiones;
import juego.Juego;

public abstract class Mision extends Juego {
    public String nombre;
    public String descripcion;
    
    @Override
    public abstract void iniciar ();

    public Mision(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public abstract void completar();
    
}

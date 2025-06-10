
package juego.misiones;
import juego.Juego;

public abstract class Mision extends Juego {
    public String nombre;
    public String descripcion;

    public Mision(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public abstract void completar();
    
}

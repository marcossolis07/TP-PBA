
package juego.misiones;


public class MisionFinal extends Mision{

    public MisionFinal(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public void iniciar() {
        System.out.println("Mision Final......");
    }
    
}

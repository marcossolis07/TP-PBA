
package juego.personajes;

import juego.mapa.Posicion;


public class MetalGear extends Personaje implements Enemigo{

    public MetalGear(String nombre, int vida, Posicion posicion) {
        super(nombre, vida, posicion);
    }
    
    @Override
    public boolean detectar(Snake snake) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
    @Override
    public void atacar(Snake snake) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

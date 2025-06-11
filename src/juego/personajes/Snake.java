
package juego.personajes;

import juego.mapa.Posicion;


public class Snake extends Personaje{

    public Snake(String nombre, int vida, Posicion posicion) {
        super(nombre, vida, posicion);
    }

    @Override
    public void mover() {
        //por ahora no implementamos movimiento automatico porque no lo necesita
        //snake se movera por input desde el menu (se maneja manualmente)
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

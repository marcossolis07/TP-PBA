
package juego.personajes;
import java.util.Random;
import juego.mapa.Posicion;


public class MetalGear extends Personaje implements Enemigo{
    int min=15;
    int max=40;
    private Random random = new Random();
    int ataqueRandom = min + random.nextInt(max - min + 1);

    public MetalGear(String nombre, int vida, Posicion posicion) {
        super(nombre, vida, posicion);
    }
    
    @Override
    public boolean detectar(Snake snake) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
    @Override
    public void atacar(Snake snake) {
        
    }
    
    public void atacarMisil(Snake snake){
        snake.recibirDanio(ataqueRandom);
        System.out.println("¡Metal Gear ataca con un Misil! (-"+ ataqueRandom +" HP)\n");
    }

    public void atacarLaser (Snake snake){
        snake.recibirDanio(ataqueRandom);
        System.out.println("¡Metal Gear ataca con un Canion Laser! (-"+ ataqueRandom +" HP)\n");
    }  
    
    @Override
    public void mover() {
    }
    
}

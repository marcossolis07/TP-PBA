package juego;
import juego.misiones.*;
import juego.mapa.*;
import juego.personajes.*;
import java.util.Scanner;

public class Juego {
    private Scanner sc = new Scanner(System.in);
    private Snake snake;
    private int misionesCompletadas;
    private int misionActual;
    private Mapa mapa;
    private int opcion = 0;
       
    public Juego(){
     
    
    misionesCompletadas = 0;
    snake = new Snake ("Snake",100, new Posicion (0,0));    
      
    }
    
    public void iniciar(){
     
        System.out.println("""
                          -------------------------------------
                                BIENVENIDOS A METAL GEAR
                          -------------------------------------
                           """);    
    boolean startLoop = true;
    while(startLoop){
        System.out.println("""
                                    MENU PRINCIPAL
                           
                                  1. INICIAR MISION
                                  2. GUARDAR ESTADO
                                  3. CARGAR ESTADO
                           
                           """); 
    opcion = sc.nextInt();
    switch (opcion){
        case 1:
            iniciarMision();
            break;
        case 2:
            guardarMision();
            break;
        case 3:
            cargarMision();
            break;
        default: System.out.println("Codigo incorrecto, ingrese nuevamente: ");
    }
    }
    }    
    public static void main(String[] args) {
        
    /*Mapa mapaMisionUno = new Mapa (7,7);   
    Mapa mapaMisionDos = new Mapa (9,9);
    */
    
    Juego juego = new Juego();
    juego.iniciar();
}

    private void iniciarMision() {
    Mision mision; 
    boolean misionSuperada = false;
    
    switch (misionActual){
        case 0: //misionHangar();
            break;
        case 1: //misionAlmacen();
            break;
        case 2: //misionBatallaFinal();
            break;
        default: System.out.println("¡Felicitaciones! Has completado todas las misiones");
                
           }
           
    }

    private void guardarMision() {
    }

    private void cargarMision() {
    }
    }

/*
// 1. Crear el mapa
        Mapa mapa = new Mapa(5, 5);

        // 2. Crear Snake en (2, 2)
        Snake snake = new Snake("Snake", 100, new Posicion(2, 2));
        mapa.colocarPersonaje(snake);

        // 3. Crear Guardia en (2, 4)
        Guardia guardia = new Guardia("Guardia", 100, new Posicion(2, 4), mapa);
        mapa.colocarPersonaje(guardia);

        // 4. Mostrar mapa inicial
        System.out.println("Mapa INICIAL:");
        mapa.mostrar();

        while (snake.getVida() != 0) {
            // 5. El guardia patrulla
            System.out.println("\nGuardia patrullando...");
            guardia.patrullar();

            // 6. Después de patrullar, intentamos detectar y atacar a Snake
            guardia.atacar(snake);

            // 7. Mostrar mapa final
            System.out.println("\nMapa FINAL:");
            mapa.mostrar();

        }

        // 8. Mostrar vida de Snake
        System.out.println("\nVida de Snake: " + snake.getVida());
*/

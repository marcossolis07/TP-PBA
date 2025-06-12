package juego;

import juego.misiones.*;
import juego.mapa.*;
import juego.personajes.*;
import java.util.Scanner;

public class Juego {

    private Scanner sc = new Scanner(System.in);
    private Snake snake;
    private int misionesCompletadas; //Atributo para saber que mision esta completa
    private int misionActual; //Atributo para saber que mision iniciar
    private Mapa mapa;
    private int opcion = 0;

    public Juego() {

        misionActual = 0;
        misionesCompletadas = 0;
        snake = new Snake("Snake", 100, new Posicion(0, 0));

    }

    public void iniciar() {

        System.out.println("""
                          -------------------------------------
                                BIENVENIDOS A METAL GEAR
                          -------------------------------------
                           """);
        boolean startLoop = true;
        while (startLoop) {
            System.out.println("""
                                    MENU PRINCIPAL
                           
                                  1. INICIAR MISION
                                  2. GUARDAR ESTADO
                                  3. CARGAR ESTADO
                                 
                           """);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    iniciarMision();
                    break;
                case 2:
                    guardarMision();
                    break;
                case 3:
                    cargarMision();
                    break;

                default:
                    System.out.println("Codigo incorrecto, ingrese nuevamente: ");
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
        boolean misionCompleta = false;
        switch (misionActual) {
            case 0:
                mision = new MisionIntermedia("Hangar de entrada", "Encontrar una tarjeta de acceso evitando a los guardias.", 0);
                if (mision.iniciar(snake)) {
                    misionCompleta = true;
                    misionesCompletadas++;
                    misionActual++;
                }
                break;
            case 1:
                mision = new MisionIntermedia("Almacén de Armas", "Recoger explosivos C4.", 1);
                if (mision.iniciar(snake)) {
                    misionCompleta = true;
                    misionesCompletadas++;
                    misionActual++;
                }
                break;
            case 2:
                mision = new MisionFinal("", "");
                if (mision.iniciar(snake)) {
                    misionCompleta = true;
                    misionesCompletadas++;
                    misionActual++;
                }
                break;
            default:
                System.out.println("¡Felicitaciones! Has completado todas las misiones");

        }

    }

    private String guardarMision() {
        //pasamos de int a String para poder guardarlo y poder usarlo despues
        String codigo = String.valueOf(misionesCompletadas);
        System.out.println("\n--- GUARDAR ESTADO ---");
        System.out.println("Tu código de progreso es: " + codigo);
        return codigo;
    }

    private void cargarMision() {
        System.out.println("\n--- CARGAR ESTADO ---");
        System.out.println("Ingresa tu código de progreso: : ");

        if (sc.hasNextInt()) { // verificamos y devuelve true si el usuario escribe un numero entero
            int valor = sc.nextInt();
            sc.nextLine(); //limpiamos el buffer

            if (valor >= 0 && valor <= 3) {
                misionesCompletadas = valor;
                misionActual = valor;
                //ponemos valor + 1, porque por ejemplo si el valor es 0 se encuentra en la mision 1
                //y asi con los otros casos
                System.out.println("Código cargado correctamente. Estas en la mision " + (valor + 1));
            } else {
                System.out.println("Código invalido. Debe estar entre 0 y 3");
            }

        } else {
            System.out.println("Código inválido. Debe ser un número");
        }
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

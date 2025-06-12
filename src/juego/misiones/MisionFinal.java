package juego.misiones;

import java.util.Random;
import java.util.Scanner;
import juego.personajes.MetalGear;
import juego.personajes.Snake;

public class MisionFinal extends Mision {

    //constructor
    public MisionFinal(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    @Override
    public boolean iniciar(Snake snake) {
        Scanner sc = new Scanner(System.in);
        MetalGear rex = new MetalGear("Metal Gear REX", 100); //creamos instancia de metal gear
        snake.setVida(100); // seteamos la vida de snake a 100

        System.out.println("\n Metal Gear REX aparece!");

        //aca arranca el combate por turnos
        while (!snake.estaMuerto() && !rex.estaMuerto()) {
            System.out.println("\n Tu vida: " + snake.getVida() + "| Vida de rex: " + rex.getVida());
            System.out.println("--- Turno de Snake ---");
            System.out.println("1- Disparar misil");
            System.out.println("2- Esquivar");
            System.out.print("Elegi una opcion: ");

            int eleccion = sc.nextInt();
            sc.nextLine(); //limpiamos el buffer

            switch (eleccion) {
                case 1:
                    int danio = snake.atacar(); //snake ataca y devuelve daño
                    rex.recibirDanio(danio);
                    break;
                case 2:
                    System.out.println(snake.getNombre() + " intenta esquivar el proximo ataque...");
                    //no hacemos nada aca, el metodo esquivar se ejecuta en el turno enemigo
                    break;

                default:
                    System.out.println("Opcion invalida, perdes el turno");

            }

            //si metal gear muere, se corta antes de que ataque
            if (rex.estaMuerto()) {
                break; //usamos el break para salir del while
            }

            System.out.println("\n--- Turno de Metal Gear ---");
            if (eleccion == 2) {
                //snake esquiva un ataque con daño aleatorio
                int ataque = rex.atacar(snake);
                snake.esquivar(ataque);
            } else {
                //metal gear ataca normalmente
                rex.atacar(snake);
            }
        }

        //resultado final
        if (snake.estaMuerto()) {
            System.out.println("\nMetal Gear te mato! Mision fallida");
            return false;
        } else {
            System.out.println("\nVictoria! Derrotaste a Metal Gear REX");
            return true;
        }
    }

}


package juego.misiones;

import juego.mapa.Celda;
import juego.mapa.Mapa;
import juego.mapa.Posicion;
import juego.objetos.Objeto;
import juego.personajes.Guardia;
import juego.personajes.Snake;

import java.util.Random;
import java.util.Scanner;

public class MisionIntermedia extends Mision{
    Scanner sc = new Scanner (System.in);
    private final Random random = new Random();
    private int numMision;

    public MisionIntermedia(String nombre, String descripcion, int mision) {
        super(nombre, descripcion);
        this.numMision = mision;
    }
    
    @Override
    public boolean iniciar(Snake snake) {
        switch (numMision){
            case 0: System.out.println("Mision 1 - Hangar de Entrada \n");
                return hangar(snake);
            case 1: System.out.println("Mision 2 - Almacen de Armas \n");
                return almacen(snake);
            default:
                return false;
    }
} 

    private boolean hangar(Snake snake) {
        int cantidadEnemigos = 4;
        int tamanioMapa = 7;
        Mapa mapa = new Mapa(tamanioMapa, tamanioMapa, cantidadEnemigos);
        mapa.colocarPersonaje(snake);
        mapa.getCelda(0,4).setObjeto(new Objeto ("Tarjeta"));
        mapa.getCelda(3, 6).setPuertaBloqueda(true);

        for (int i = 0; i < cantidadEnemigos; i++) {
            int x = random.nextInt(tamanioMapa);
            int y = random.nextInt(tamanioMapa);
            if (mapa.getCelda(x, y).estaLibre() && (Math.abs(x - snake.getPosicion().getX()) + Math.abs(y - snake.getPosicion().getY())) >= 2){
            Guardia guardia = new Guardia("Guardia",100,new Posicion(x,y),mapa);
            mapa.colocarPersonaje(guardia);
        }   else{
                i--;
            }
               
        }

        while(true){
            mapa.mostrar();
            System.out.println("Es tu turno de mover a Snake (Utiliza WASD):");
            String mover = sc.nextLine().toUpperCase();
            int x = snake.getPosicion().getX();
            int y = snake.getPosicion().getY();

            switch(mover){
                case "W":
                        x = x-1;
                        break;
                case "A":
                        y = y-1;
                        break;
                case "S":
                        x = x+1;
                        break;
                case "D":
                        y= y+1;
                        break;
                default: 
                    System.out.println("Movimiento Invalido! Intente nuevamente.");
                    continue;
            }

            if (x < 0 || y < 0 || x >= tamanioMapa || y >= tamanioMapa) {
            System.out.println("No podés salir del mapa.");
            continue;
        }

            Celda movSnake = mapa.getCelda(x, y);
            if (movSnake == null) {
                System.out.println("Movimiento inválido (fuera del mapa).");
                continue;
            }

            if(movSnake.isPuertaBloqueda() && !(snake.siTieneTarjeta())){
                System.out.println("La puerta se encuenta bloqueada, necesitas la tarjeta de acceso.");
                continue;
        }

            mapa.moverPersonaje(snake, x, y);
            
            Objeto obj = movSnake.getObjeto();
        if (obj != null && obj.getTipo().equals("Tarjeta") && !obj.fueRecogido()) {
            snake.recogerTarjeta(); //asigna la tarjeta a snake
            obj.recoger(); // asigna true a fueRecogido
            movSnake.setObjeto(null); // Saca el objeto de la celda
        }

        if (x == 3 && y == 6 && snake.siTieneTarjeta()){
            System.out.println("Mision Completada, entraste al Hangar \n");
            this.setMisionCompletada(true);
            return true;
            
        }

            int cantidad = mapa.getCantidadGuardias();
            if (cantidad > 0) {
                Guardia guardiaRandom = mapa.getGuardia(random.nextInt(cantidad));
                guardiaRandom.patrullar();

                for (int i = 0; i < cantidad; i++) {
                    Guardia guardia = mapa.getGuardia(i);
                    if (guardia.detectar(snake)) {
                        int vida = guardia.atacar(snake);
                        if (vida == 0) {
                            System.out.println("¡Te capturó un guardia! Perdiste.");
                            return false;
                        }
                    }
                }
        
        }}   
            
        }

    private boolean almacen(Snake snake){
        int cantidadEnemigos = 4;
        int tamanioMapa = 9;
        Mapa mapa = new Mapa(tamanioMapa, tamanioMapa, cantidadEnemigos);
        mapa.colocarPersonaje(snake);
        mapa.getCelda(1,4).setObjeto(new Objeto ("C4"));
        mapa.getCelda(5, 6).setPuertaBloqueda(true);

        for(int i=0; i<cantidadEnemigos;i++){
            int x = random.nextInt(tamanioMapa);
            int y = random.nextInt(tamanioMapa);
            if (mapa.getCelda(x, y).estaLibre() && (Math.abs(x - snake.getPosicion().getX()) + Math.abs(y - snake.getPosicion().getY())) >= 2){
            Guardia guardia = new Guardia("Guardia",100,new Posicion(x,y),mapa);
            mapa.colocarPersonaje(guardia);
        }   else{
                i--;
            }
        }

        while (true) {
            mapa.mostrar();
            System.out.println("Es tu turno de mover a Snake (Utiliza WASD):");
            String mover = sc.nextLine().toUpperCase();
            int x = snake.getPosicion().getX();
            int y = snake.getPosicion().getY();

            switch(mover){
                case "W":
                        x = x-1;
                        break;
                case "A":
                        y = y-1;
                        break;
                case "S":
                        x = x+1;
                        break;
                case "D":
                        y= y+1;
                        break;
                default: 
                    System.out.println("Movimiento Invalido! Intente nuevamente.");
                    continue;
            }

            if (x < 0 || y < 0 || x >= tamanioMapa || y >= tamanioMapa) {
            System.out.println("No podés salir del mapa.");
            continue;
        }

            Celda movSnake = mapa.getCelda(x, y);
            if (movSnake == null) {
                System.out.println("Movimiento inválido (fuera del mapa).");
                continue;
            }

            if (movSnake.isPuertaBloqueda()) {
                if (!snake.siTieneBomba()) {
                    System.out.println("La puerta se encuenta bloqueada, necesitas la bomba C4.");
                continue;
        }

                boolean guardiaCerca = false;
                for (int i = 0; i < mapa.getCantidadGuardias(); i++) {
                    if (mapa.getGuardia(i).detectarC4(snake)) {
                        guardiaCerca = true;
                        break;
                    }
                }
                if (guardiaCerca) {
                    System.out.println("No es posible completar la mision, guardias cerca");
                    continue;
                }

                //sin guardias cerca: explota la puerta
                System.out.println("¡Colocaste el C4! BOOM La puerta ha sido destruida.");
                movSnake.setPuertaBloqueda(false);
            }

            mapa.moverPersonaje(snake, x, y);
            
            Objeto obj = movSnake.getObjeto();
        if (obj != null && obj.getTipo().equals("C4") && !obj.fueRecogido()) {
            snake.recogerBomba();//asigna la bomba a snake
            obj.recoger(); // asigna true a fueRecogido
            movSnake.setObjeto(null); // Saca el objeto de la celda
            System.out.println("¡Obtuviste la bomba C4!");
            
        }

            if (x == 3 && y == 6 && snake.siTieneBomba()){
                System.out.println("Mision completada, entraste al almcacen de armas");
                this.setMisionCompletada(true);
                return true;
        }

            int cantidad = mapa.getCantidadGuardias();
            if (cantidad > 0) {
                Guardia guardiaRandom = mapa.getGuardia(random.nextInt(cantidad));
                guardiaRandom.patrullar();

                for (int i = 0; i < cantidad; i++) {
                    Guardia guardia = mapa.getGuardia(i);
                    if (guardia.detectar(snake)) {
                        int vida = guardia.atacar(snake);
                        if (vida == 0) {
                            System.out.println("¡Te capturó un guardia! Perdiste.");
                            return false;
                        }
                    }
                }

            }
        }
    }
        
        
    }
    
    



package juego.misiones;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import juego.mapa.Celda;
import juego.mapa.Mapa;
import juego.mapa.Posicion;
import juego.objetos.Objeto;
import juego.personajes.*;

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
                hangar(snake);
                break;
            case 1: System.out.println("Mision 2 - Almacen de Armas \n"); 
                almacen(snake);
                break;
    }
        return false;
} 

    private boolean hangar(Snake snake) {
        int cantidadEnemigos = 4;
        int tamanioMapa = 7;
        Mapa mapa = new Mapa (tamanioMapa,tamanioMapa);
        mapa.colocarPersonaje(snake);
        mapa.getCelda(0,4).setObjeto(new Objeto ("Tarjeta"));
        mapa.getCelda(3, 6).setPuertaBloqueda(true);
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
        
       List<Guardia> guardias = mapa.getGuardias();
        if (!guardias.isEmpty()) {
            Guardia guardiaRandom = guardias.get(random.nextInt(guardias.size()));
            guardiaRandom.patrullar();

            for (Guardia guardia : guardias) {
                if (guardia.detectar(snake)) {
                    int vida = guardia.atacar(snake);
                    if (vida == 0) {
                        System.out.println("¡Te capturó un guardia! Perdiste.");
                        break;
                    }
                }
            }
        
        }}   
            
        }
    private boolean almacen(Snake snake){
        boolean startLoop = true;
        int cantidadEnemigos = 4;
        int tamanioMapa = 9;
        Mapa mapa = new Mapa (tamanioMapa,tamanioMapa);
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
        while(startLoop){
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
        if (obj != null && obj.getTipo().equals("C4") && !obj.fueRecogido()) {
            snake.recogerBomba();//asigna la bomba a snake
            obj.recoger(); // asigna true a fueRecogido
            movSnake.setObjeto(null); // Saca el objeto de la celda
            System.out.println("¡Obtuviste la bomba C4!");
            
        }
        if (x == 3 && y == 6 && snake.siTieneBomba()){
            for (Guardia guardia : mapa.getGuardias()){
                if(guardia.detectarC4(snake)){
                    System.out.println("No es posible completar la mision, guardias cerca");
                    break;
                }
                else{
                    System.out.println("Mision Completada, entraste al almacen de armas");
                    this.setMisionCompletada(true);
                    return true;
                }
            }
        }
        
       List<Guardia> guardias = mapa.getGuardias();
        if (!guardias.isEmpty()) {
            Guardia guardiaRandom = guardias.get(random.nextInt(guardias.size()));
            guardiaRandom.patrullar();

            for (Guardia guardia : guardias) {
                if (guardia.detectar(snake)) {
                    int vida = guardia.atacar(snake);
                    if (vida == 0) {
                        System.out.println("¡Te capturó un guardia! Perdiste");
                        startLoop = false;
                        return false;
                        
                    }
                }
            }
        
        }}   return this.misionCompletada;
        }
        
        
    }
    
    


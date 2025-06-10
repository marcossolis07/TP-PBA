package juego.objetos;

public class Objeto {

    private String tipo;
    private boolean recogido;

    //constructor
    public Objeto(String tipo) {
        this.tipo = tipo;
        this.recogido = false; //arranca el false, porque no fue recogido
    }

    //getter del tipo, puede ser Tarjeta, C4, etc
    public String getTipo() {
        return tipo;
    }

    //metodo para saber si el objeto es recogido
    public boolean fueRecogido() {
        return recogido;
    }

    //metodo para recoger un objeto
    public void recoger() {
        this.recogido = true;
    }

    @Override
    public String toString() {
        return tipo + (recogido ? " (recogido)" : "");
    }

}

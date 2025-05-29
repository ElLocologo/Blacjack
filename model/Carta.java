package model;

// Representa una carta de la baraja
public class Carta {
    public String valor;
    public String palo;
    public int puntaje;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.puntaje = calcularPuntaje(valor);
    }

    private int calcularPuntaje(String valor) {
        if (valor.equals("A")) return 11;
        if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) return 10;
        return Integer.parseInt(valor);
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}

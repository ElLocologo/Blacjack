package model;

// Representa a un jugador
public class Jugador {
    public String nombre;
    public Carta[] mano;
    public int numCartas;
    public int puntaje;
    public String estado; // "jugando", "plantado", "perdio"
    public int partidasGanadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new Carta[12]; // Máximo 12 cartas sin pasarse
        this.numCartas = 0;
        this.puntaje = 0;
        this.estado = "jugando";
        this.partidasGanadas = 0;
    }

    public void agregarCarta(Carta carta) {
        mano[numCartas++] = carta;
        puntaje = calcularPuntaje();
    }

    private int calcularPuntaje() {
        int total = 0;
        int ases = 0;
        for (int i = 0; i < numCartas; i++) {
            total += mano[i].puntaje;
            if (mano[i].valor.equals("A")) ases++;
        }
        // Ajuste de Ases
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }

    public void mostrarMano() {
        for (int i = 0; i < numCartas; i++) {
            System.out.println("  " + mano[i]);
        }
        System.out.println("Puntaje: " + puntaje);
    }
}

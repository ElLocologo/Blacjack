package model;

// Nodo para la cola de turnos
public class NodoJugador {
    public Jugador jugador;
    public NodoJugador siguiente;

    public NodoJugador(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}

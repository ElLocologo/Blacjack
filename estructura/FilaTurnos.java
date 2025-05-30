package estructura;
import model.Jugador;
import model.NodoJugador;

// Implementación propia de cola para turnos
public class FilaTurnos {
    private NodoJugador frente;
    private NodoJugador fin;

    public FilaTurnos() {
        frente = null;
        fin = null;
    }

    public void encolar(Jugador jugador) {
        NodoJugador nuevo = new NodoJugador(jugador);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Jugador desencolar() {
        if (frente == null) return null;
        Jugador jugador = frente.jugador;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return jugador;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}

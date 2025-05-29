package estructura;
import model.Carta;
import model.NodoCarta;

// Implementación propia de pila para historial de cartas jugadas
public class PilaCartas {
    private NodoCarta tope;

    public PilaCartas() {
        tope = null;
    }

    public void apilar(Carta carta) {
        NodoCarta nuevo = new NodoCarta(carta);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Carta desapilar() {
        if (tope == null) return null;
        Carta carta = tope.carta;
        tope = tope.siguiente;
        return carta;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void mostrarHistorial() {
        NodoCarta actual = tope;
        System.out.println("Historial de cartas jugadas:");
        while (actual != null) {
            System.out.println(actual.carta);
            actual = actual.siguiente;
        }
    }
}

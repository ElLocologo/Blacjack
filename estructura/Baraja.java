package estructura;
import model.Carta;
import model.NodoCarta;

// Lista enlazada simple para la baraja
public class Baraja {
    private NodoCarta cabeza;
    private int tamano;

    public Baraja() {
        cabeza = null;
        tamano = 0;
    }

    // Agrega una carta al final de la baraja
    public void agregarCarta(Carta carta) {
        NodoCarta nuevo = new NodoCarta(carta);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCarta actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamano++;
    }

    // Roba (elimina y retorna) la primera carta de la baraja
    public Carta robarCarta() {
        if (cabeza == null) return null;
        Carta carta = cabeza.carta;
        cabeza = cabeza.siguiente;
        tamano--;
        return carta;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamano() {
        return tamano;
    }

    // Muestra las cartas restantes en la baraja
    public void mostrarBaraja() {
        NodoCarta actual = cabeza;
        while (actual != null) {
            System.out.println(actual.carta);
            actual = actual.siguiente;
        }
    }
}

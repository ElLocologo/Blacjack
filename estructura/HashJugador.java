package estructura;
import model.Jugador;

// Tabla hash propia para jugadores
public class HashJugador {
    private final Jugador[] tabla;
    private final int capacidad;

    public HashJugador(int capacidad) {
        this.capacidad = capacidad;
        tabla = new Jugador[capacidad];
    }

    private int hash(String nombre) {
        int hash = 0;
        for (int i = 0; i < nombre.length(); i++) {
            hash = (hash * 31 + nombre.charAt(i)) % capacidad;
        }
        return hash;
    }

    public void agregarJugador(Jugador jugador) {
        int idx = hash(jugador.nombre);
        while (tabla[idx] != null) {
            idx = (idx + 1) % capacidad;
        }
        tabla[idx] = jugador;
    }

    public Jugador obtenerJugador(String nombre) {
        int idx = hash(nombre);
        int start = idx;
        while (tabla[idx] != null) {
            if (tabla[idx].nombre.equals(nombre)) return tabla[idx];
            idx = (idx + 1) % capacidad;
            if (idx == start) break;
        }
        return null;
    }
}

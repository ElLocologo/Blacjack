package dealer;

// Nodo para el árbol de decisión del dealer
public class NodoArbolDecision {
    public int valor;
    public String accion; // "pedir" o "plantar"
    public NodoArbolDecision izquierda;
    public NodoArbolDecision derecha;

    public NodoArbolDecision(int valor, String accion) {
        this.valor = valor;
        this.accion = accion;
        this.izquierda = null;
        this.derecha = null;
    }
}

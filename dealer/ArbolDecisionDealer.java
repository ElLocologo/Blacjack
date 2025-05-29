package dealer;

public class ArbolDecisionDealer {
    private final NodoArbolDecision raiz;

    public ArbolDecisionDealer() {
        // Si puntaje < 17: pedir, si >= 17: plantar
        raiz = new NodoArbolDecision(17, "plantar");
        raiz.izquierda = new NodoArbolDecision(0, "pedir");
    }

    public String decidir(int puntaje) {
        NodoArbolDecision actual = raiz;
        while (actual != null) {
            if (puntaje < actual.valor && actual.izquierda != null) {
                actual = actual.izquierda;
            } else {
                return actual.accion;
            }
        }
        return "plantar";
    }
}

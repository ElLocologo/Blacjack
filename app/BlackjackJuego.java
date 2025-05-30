package app;

import dealer.ArbolDecisionDealer;
import estructura.Baraja;
import estructura.FilaTurnos;
import estructura.PilaCartas;
import estructura.TablaJugador;
import java.util.Scanner;
import model.Carta;
import model.Jugador;

// Clase principal que orquesta el juego
public class BlackjackJuego {
    private final Baraja baraja;
    private final PilaCartas historial;
    private final FilaTurnos FilaTurnos;
    private final TablaJugador TablaJugadores;
    private final ArbolDecisionDealer arbolDealer;
    private Jugador dealer;
    private Jugador jugadorHumano;
    private final Scanner scanner;

    public BlackjackJuego() {
        baraja = new Baraja();
        historial = new PilaCartas();
        FilaTurnos = new FilaTurnos();
        TablaJugadores = new TablaJugador(10);
        arbolDealer = new ArbolDecisionDealer();
        scanner = new Scanner(System.in);
        inicializarBaraja();
        barajar();
    }

    private void inicializarBaraja() {
        String[] palos = {"Corazones", "Diamantes", "Picas", "Tréboles"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String palo : palos) {
            for (String valor : valores) {
                baraja.agregarCarta(new Carta(valor, palo));
            }
        }
    }

    private void barajar() {
        // Barajado simple: extrae cartas aleatoriamente y las vuelve a insertar
        Carta[] temp = new Carta[52];
        int i = 0;
        while (!baraja.estaVacia()) {
            temp[i++] = baraja.robarCarta();
        }
        for (int j = 0; j < 52; j++) {
            int idx = (int)(Math.random() * (52 - j)) + j;
            Carta aux = temp[j];
            temp[j] = temp[idx];
            temp[idx] = aux;
        }
        for (Carta c : temp) {
            baraja.agregarCarta(c);
        }
    }

    public void jugar() {
        System.out.println("Bienvenido a Blackjack versión consola");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        jugadorHumano = new Jugador(nombre);
        dealer = new Jugador("Dealer");
        TablaJugadores.agregarJugador(jugadorHumano);
        TablaJugadores.agregarJugador(dealer);
        FilaTurnos.encolar(jugadorHumano);
        FilaTurnos.encolar(dealer);
        // Repartir dos cartas a cada jugaador

        for (int i = 0; i < 2; i++) {
            jugadorHumano.agregarCarta(baraja.robarCarta());
            dealer.agregarCarta(baraja.robarCarta());
        }
        // Turnos
        while (true) {
            Jugador actual = FilaTurnos.desencolar();
            if (actual == null) break;
            if (actual == jugadorHumano) {
                turnoJugador(jugadorHumano);
            } else {
                turnoDealer(dealer);
            }
            if (!jugadorHumano.estado.equals("jugando") && !dealer.estado.equals("jugando")) break;
            FilaTurnos.encolar(actual);
        }
        mostrarResultados();
    }

    private void turnoJugador(Jugador jugador) {
        if (!jugador.estado.equals("jugando")) return;
        System.out.println("\nTurno de: " + jugador.nombre);
        System.out.println(jugador.nombre + " tiene:");
        jugador.mostrarMano();
        if (jugador.puntaje > 21) {
            System.out.println("Te pasaste de 21. Pierdes.");
            jugador.estado = "perdio";
            return;
        }
        System.out.print("¿Desea otra carta? (s/n): ");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("s")) {
            Carta carta = baraja.robarCarta();
            jugador.agregarCarta(carta);
            historial.apilar(carta);
            turnoJugador(jugador);
        } else {
            jugador.estado = "plantado";
        }
    }

    private void turnoDealer(Jugador dealer) {
        if (!dealer.estado.equals("jugando")) return;
        System.out.println("\nTurno de: Dealer");
        System.out.println("Dealer tiene:");
        dealer.mostrarMano();
        String decision = arbolDealer.decidir(dealer.puntaje);
        while (decision.equals("pedir")) {
            System.out.println("El dealer toma una carta...");
            Carta carta = baraja.robarCarta();
            dealer.agregarCarta(carta);
            historial.apilar(carta);
            if (dealer.puntaje > 21) {
                System.out.println("El dealer se pasó de 21.");
                dealer.estado = "perdio";
                return;
            }
            decision = arbolDealer.decidir(dealer.puntaje);
        }
        System.out.println("El dealer se planta.");
        dealer.estado = "plantado";
    }

    private void mostrarResultados() {
        System.out.println("\n--- RESULTADOS ---");
        System.out.println(jugadorHumano.nombre + " tiene:");
        jugadorHumano.mostrarMano();
        System.out.println("\nDealer tiene:");
        dealer.mostrarMano();
        if (jugadorHumano.puntaje > 21) {
            System.out.println("\nDealer gana!");
        } else if (dealer.puntaje > 21) {
            System.out.println("\n" + jugadorHumano.nombre + " gana! 🎉");
        } else if (jugadorHumano.puntaje > dealer.puntaje) {
            System.out.println("\n" + jugadorHumano.nombre + " gana! 🎉");
        } else if (jugadorHumano.puntaje < dealer.puntaje) {
            System.out.println("\nDealer gana!");
        } else {
            System.out.println("\nEmpate!");
        }
        System.out.println();
        historial.mostrarHistorial();
    }

    public static void main(String[] args) {
        BlackjackJuego juego = new BlackjackJuego();
        juego.jugar();
    }
}

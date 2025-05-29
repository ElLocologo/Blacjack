# Proyecto Black Jack

Este proyecto implementa el juego de Blackjack (21) en consola usando Java, con todas las estructuras de datos desarrolladas desde cero (sin usar colecciones estándar de Java). El juego simula una partida entre un jugador humano y un dealer automático.

## Objetivo del Juego
El objetivo es acercarse lo más posible a 21 puntos sin pasarse. El jugador puede pedir cartas o plantarse, mientras que el dealer toma decisiones basadas en un árbol binario de decisión.

## Estructuras de Datos Implementadas
- **Lista enlazada**: Baraja de cartas.
- **Pila**: Historial de cartas jugadas.
- **Cola**: Gestión de turnos.
- **Árbol binario de decisión**: Lógica del dealer.
- **Tabla hash**: Control de estado de los jugadores.

## Clases Principales
- `Carta`: Representa una carta de la baraja.
- `NodoCarta`: Nodo para la lista enlazada y la pila.
- `Baraja`: Lista enlazada simple para la baraja.
- `PilaCartas`: Pila para el historial de cartas jugadas.
- `ColaTurnos`: Cola para alternar turnos.
- `NodoJugador`: Nodo para la cola de turnos.
- `Jugador`: Información y mano de cada jugador.
- `HashJugador`: Tabla hash para almacenar jugadores.
- `NodoArbolDecision`: Nodo del árbol binario de decisión del dealer.
- `ArbolDecisionDealer`: Árbol binario para la lógica del dealer.
- `BlackjackJuego`: Clase principal que orquesta el juego.

## Ejecución
1. Compila todos los archivos `.java`:
   ```powershell
   javac *.java
   ```
2. Ejecuta el juego:
   ```powershell
   java BlackjackJuego
   ```

## Autor
- [Cardenas Gaviria](https://github.com/ElLocologo)

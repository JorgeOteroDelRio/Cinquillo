package IU;

import static IU.ES.leeString;
import core.Baraja;
import core.Jugador;

/**
 * Representa el cinquillo_oro, con sus reglas. Se recomienda una implementación
 * modular.
 */
public class Juego {

    /**
     * Se crean los jugadores y permite jugar o terminar el juego. Es posible
     * jugar varias partidas.
     */
    public static void inicioJuego() {
        Baraja.crearBaraja();
        Baraja.barajar();
        Jugador[] jugadores = new Jugador[4];
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador(leeString("Introduzca el nombre del jugador " + (i + 1) + ": "));
        }

        for (Jugador j : jugadores) {
            j.robarCartas();
            j.getMano().mostrarCartas();
        }
    }

}

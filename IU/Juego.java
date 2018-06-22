package IU;

import static IU.ES.leeString;
import core.Baraja;
import core.Carta;
import core.Jugador;
import java.util.ArrayList;

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
            lanzarAccionJugador(j);
        }

    }

    public static void lanzarAccionJugador(Jugador j) {
        ArrayList<Carta> cartasPosibles = j.getMano().devolverCartasPosibles();
        boolean esperandoCarta = true;
        System.out.println("Cartas POSIBLES");
        for (Carta c : cartasPosibles) {
            System.out.print(c.toString() + " | ");
        }
        System.out.println("\n");
        int opcion;
        do {
            System.out.println("MENU\n"
                    + "1) Ver mis cartas.\n"
                    + "2) Ver cartas en la mesa.\n"
                    + "3) Jugar carta.");
            opcion = ES.leeNum("ESCOJA OPCION DE JUEGO: ");
            switch (opcion) {
                case 1:
                    j.getMano().mostrarCartas();
                    break;
                case 2:
                    //Falta implementar
                    break;
                case 3:
                    esperandoCarta = false;
                    if (cartasPosibles.size() == 0) {
                        System.out.println("Pasaste el turno.");
                    }else{
                        j.colocarCarta();
                    }   
                    break;
            }
        } while (esperandoCarta);

    }

}

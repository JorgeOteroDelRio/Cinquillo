package core;

import java.util.ArrayList;

/**
 * Representa a un jugador de la partida, identificado por el nombre, las cartas
 * de la mano y puntos acumulados Funcionalidad: recibir las 12 cartas, de entre
 * las cartas posibles a colocar selecciona una, consultar/modificar puntos, etc
 */
public class Jugador {

    private final String nombre;
    private ArrayList<Carta> cartas_mano;
    private int puntosAcumulados;

    public Jugador(String n) {
        this.nombre = n;
        cartas_mano = new ArrayList();
        puntosAcumulados = 0;
    }

    public void getCartas() {
        byte cartasRobadas = 0;
        for (int i = 0; i < Baraja.TAMANHO; i++) {
            Carta c = Baraja.quitarCarta();
            if (c != null) {
                cartas_mano.add(c);
                Baraja.cartas[i] = null;
                cartasRobadas++;
                if (cartasRobadas == 12) {
                    break;
                }
            }
        }

        System.out.println(nombre + " ha robado sus cartas.");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", cartas_mano=" + cartas_mano + ", puntosAcumulados=" + puntosAcumulados + '}';
    }

    /**
     * Representa las cartas de cada jugador en cada momento de la partida.
     * Estructura: se almacenarán en un array estático. Funcionalidad: añadir
     * una carta, quitar una carta, devolver cartas posibles, visualizar, etc
     */
    public class Mano {

    }

}

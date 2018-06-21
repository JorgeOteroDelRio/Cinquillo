package core;

import java.util.ArrayList;

/**
 * Representa a un jugador de la partida, identificado por el nombre, las cartas
 * de la mano y puntos acumulados Funcionalidad: recibir las 12 cartas, de entre
 * las cartas posibles a colocar selecciona una, consultar/modificar puntos, etc
 */
public class Jugador {

    private final String nombre;
    private int puntosAcumulados;
    private Mano mano;

    public Jugador(String n) {
        this.nombre = n;
        mano = new Mano();
        puntosAcumulados = 0;
    }

    public void robarCartas() {
        byte cartasRobadas = 0;
        for (int i = 0; i < Baraja.TAMANHO; i++) {
            Carta c = Baraja.quitarCarta();
            if (c != null) {
                mano.anhadirCarta(c);
                cartasRobadas++;
                if (cartasRobadas == 12) {
                    break;
                }
            }
        }

        System.out.println(nombre + " ha robado sus cartas.");

    }

    public Mano getMano() {
        return mano;
    }
    
    

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntosAcumulados=" + puntosAcumulados + '}';
    }

    /**
     * Representa las cartas de cada jugador en cada momento de la partida.
     * Estructura: se almacenarán en un array estático. Funcionalidad: añadir
     * una carta, quitar una carta, devolver cartas posibles, visualizar, etc
     */
    public class Mano {

        private Carta[] cartas_mano;

        public Mano() {
            cartas_mano = new Carta[12];
        }

        public void mostrarCartas() {
            for (Carta c : cartas_mano) {
                if (c != null) {
                    System.out.println(c.toString());
                } else {
                    break;
                }
            }
        }

        private void anhadirCarta(Carta cartaNueva) {
            for (int i = 0; i < cartas_mano.length; i++) {
                if (cartas_mano[i] == null) {
                    cartas_mano[i] = cartaNueva;
                    break;
                }
            }
        }

    }

}

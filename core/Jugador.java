package core;

import IU.ES;
import core.Baraja.Palos;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

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

    public boolean colocarCarta() {
        boolean carta_jugada = false;
        boolean cartaFormato;
        String[] partes;
        Carta c = null;
        do {
            cartaFormato = true;
            String res = ES.leeString("Introduzca el numero y palo de la carta que quiere jugar con el formato: (X-PALO).");
            partes = res.split("-");
            try {
                c = new Carta(Byte.parseByte(partes[0]), Baraja.Palos.valueOf(partes[1]));
            }catch(Exception e){
                cartaFormato = false;
            }
        } while (partes.length != 2 || !cartaFormato);
        System.out.println("La carta que ha escogido es: " + c.toString());
        ArrayDeque<Carta> espadas_mesa = Mesa.getEspadas();
        if (espadas_mesa.contains(c)) {
            System.out.println("La carta escogida ya se ha jugado");
        }
        return carta_jugada;
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

        public ArrayList<Carta> devolverCartasPosibles() {
            ArrayList<Carta> cartasPosibles = new ArrayList(0);
            ArrayDeque bastos = Mesa.getBastos();
            ArrayDeque oros = Mesa.getOros();
            ArrayDeque copas = Mesa.getCopas();
            ArrayDeque espadas = Mesa.getEspadas();
            Carta c_alta = null, c_baja = null;
            for (Carta c : cartas_mano) {
                if (c.getNUMERO() == 5) {
                    cartasPosibles.add(c);
                } else {
                    for (Palos p : Baraja.Palos.values()) {
                        switch (p) {
                            case BASTOS:
                                c_alta = (Carta) bastos.pollLast();
                                c_baja = (Carta) bastos.pollFirst();
                                break;
                            case OROS:
                                c_alta = (Carta) bastos.pollLast();
                                c_baja = (Carta) bastos.pollFirst();
                                break;
                            case COPAS:
                                c_alta = (Carta) bastos.pollLast();
                                c_baja = (Carta) bastos.pollFirst();
                                break;
                            case ESPADAS:
                                c_alta = (Carta) bastos.pollLast();
                                c_baja = (Carta) bastos.pollFirst();
                                break;
                            default:
                                break;
                        }
                        if (c_alta != null && c_baja != null) {
                            if ((c.getNUMERO() - c_alta.getNUMERO()) == 1) {
                                cartasPosibles.add(c);
                                break;
                            }

                            if (c_baja.getNUMERO() - c.getNUMERO() == 1) {
                                cartasPosibles.add(c);
                                break;
                            }
                        }
                    }

                }
            }
            return cartasPosibles;
        }

    }

}

package core;

import java.util.Random;

/**
 * Representa la baraja del juego, con 48 cartas (12 de cada palo),
 * desordenadas. Estructura: Las cartas se guardarán en un array estático.
 * Funcionalidad: Crear la baraja, barajar, quitar una carta, etc
 */
public class Baraja {

    public final static int TAMANHO = 48;
    private final static int NCARTAS_PALO = 12;

    private static int nCartas = 0;

    public enum Palos {
        ESPADAS, OROS, BASTOS, COPAS
    }

    public static Carta[] cartas = new Carta[TAMANHO];

    public static void crearBaraja() {
        for (byte i = 1; i <= NCARTAS_PALO; i++) {
            for (Palos p : Palos.values()) {
                cartas[nCartas] = new Carta(i, p);
                nCartas++;
            }
        }
    }

    public static void barajar() {
        Random random = new Random(System.currentTimeMillis());
        Carta[] array = new Carta[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            array[i] = cartas[i];
        }

        int index;
        Carta temp;
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        for (int i = 0; i < TAMANHO; i++) {
            cartas[i] = array[i];
        }
        System.out.println("Cartas barajadas");
    }

    public static Carta quitarCarta() {
        Carta c;
        for (int i = 0; i < TAMANHO ; i++) {
            if(cartas[i] != null){
                c = cartas[i];
                cartas[i] = null;
                return c;
            }
        }
        return null;
    }
}

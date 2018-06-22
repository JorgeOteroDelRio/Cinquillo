package core;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Representa la mesa de juego, donde los jugadores colocan las cartas en cada
 * turno. Estructura: Se utilizará un array estático de dobles colas (Deque),
 * una para cada palo Funcionalidad: insertar la carta en su lugar correcto
 * automáticamente, visualizar, etc
 */
public class Mesa {

    private static int turno = 0;
    private static ArrayDeque<Carta> espadas = new ArrayDeque(12);
    private static ArrayDeque<Carta> copas = new ArrayDeque(12);
    private static ArrayDeque<Carta> oros = new ArrayDeque(12);
    private static ArrayDeque<Carta> bastos = new ArrayDeque(12);

    public static int getTurno() {
        return turno;
    }

    public static void setTurno(int turno) {
        Mesa.turno = turno;
    }

    public static ArrayDeque<Carta> getEspadas() {
        return espadas;
    }

    public static void setEspadas(ArrayDeque<Carta> espadas) {
        Mesa.espadas = espadas;
    }

    public static ArrayDeque<Carta> getCopas() {
        return copas;
    }

    public static void setCopas(ArrayDeque<Carta> copas) {
        Mesa.copas = copas;
    }

    public static ArrayDeque<Carta> getOros() {
        return oros;
    }

    public static void setOros(ArrayDeque<Carta> oros) {
        Mesa.oros = oros;
    }

    public static ArrayDeque<Carta> getBastos() {
        return bastos;
    }

    public static void setBastos(ArrayDeque<Carta> bastos) {
        Mesa.bastos = bastos;
    }
    
    


}

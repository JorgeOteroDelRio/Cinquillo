package core;

/**
 * Representa una carta de la baraja, formada por un numero(1..12) y un
 * palo(oros, copas, espadas y bastos)
 */
public class Carta {

    private final byte NUMERO;
    private final Baraja.Palos PALO;

    public Carta(byte numero, Baraja.Palos palo){
        this.NUMERO = numero;
        this.PALO = palo;
    }

    public byte getNUMERO() {
        return NUMERO;
    }

    public Baraja.Palos getPALO() {
        return PALO;
    }
    
    @Override
    public String toString() {
        return  "[" + NUMERO + " / " + PALO + "]";
    }

}

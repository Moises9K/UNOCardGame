package moises.Base;

import java.util.Arrays;

public class Player {

    private String name;
    private Carta[] cartas;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public Carta getCarta(int pos) {
        return cartas[pos];
    }
    public void eliminarCarta(int pos) {
        cartas[pos] = null;
    }
    public void agregarCarta(Carta carta) {
        for(int i = 0; i < cartas.length; i++){
            if(cartas[i] == null){
                cartas[i] = carta;
            }
        }
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cartas=" + Arrays.toString(cartas) +
                '}';
    }
}

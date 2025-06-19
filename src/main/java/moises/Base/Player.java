package moises.Base;

import java.util.Arrays;
import java.util.List;

public abstract class Player {

    private String name;
    private List<Carta> cartas;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Carta obtenerCarta(int i){
        return cartas.get(i);
    }

    public void añadirCarta(Carta carta){
        cartas.add(carta);
    }
    public void eliminarCarta(Carta carta){
        cartas.remove(carta);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public abstract int jugarCarta();

}

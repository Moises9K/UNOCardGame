package moises.GameLogic;

import moises.Base.*;
import moises.Cartas.Baraja;
import moises.Cartas.UNOWildCard;


public class Juego {
    private final Baraja baraja;
    private final Player[] jugadores;
    private Carta cartaactual = new UNOWildCard(WildCard.Wild);
    private int turnoactual = 0;
    private int turnomax;
    private boolean reverse = false;


    public Player[] getJugadores() {
        return jugadores;
    }


    public Juego(Baraja baraja, Player[] jugadores) {
        this.baraja = baraja;
        this.jugadores = jugadores;
        inicializarJuego();
        cartaactual.setColor(Colores.Green);
    }

    private void inicializarJuego(){
        baraja.aleatorizarCartas(jugadores);
        turnomax = jugadores.length - 1;
        System.out.println("Juego inicializado");

    }

    private boolean movimientoValido(Carta cartaAjugar,Carta cartaEnMesa){
        return cartaAjugar.jugadaValida(cartaEnMesa);

    }

    public boolean realizarJugada(){
        System.out.println("Carta actual: " + cartaactual.getName());

        int choice = jugadores[turnoactual].jugarCarta();
        if(choice == jugadores[turnoactual].getCartas().size()){
            Carta cartaaleatoria = baraja.aleatorizarCarta();
            jugadores[turnoactual].añadirCarta(cartaaleatoria);
            return true;

        }
        Carta cartaelegida = jugadores[turnoactual].obtenerCarta(choice);

        if (movimientoValido(cartaelegida,cartaactual)){
            pasarCarta(cartaelegida);
            cartaelegida.realizarEfecto(this);
            pasarTurno();
            return true;
        }
        else{
            System.out.println("Jugada invalida");
            return false;
        }

    }

    public void drawCardsPlayer(Carta[] cartas){
        for (Carta carta : cartas) {
            jugadores[turnoactual].añadirCarta(carta);
        }
        System.out.println("Agregando carta para jugador: " + turnoactual);
        pasarTurno();
    }

    private void pasarTurno(){
        if (!reverse){
            if(turnoactual == turnomax){
                turnoactual = 0;
            }
            else{
                turnoactual++;
            }
        }
        else if(reverse){
            if(turnoactual == 0){
                turnoactual = turnomax;

            }
            else{
                turnoactual--;
            }
        }
    }

    private void pasarCarta(Carta carta){
        cartaactual = carta;
        jugadores[turnoactual].eliminarCarta(carta);
    }


    public void skipFunction(){
        pasarTurno();

    }

    public void reverseFunction(){
        if(!reverse){
            reverse = true;
        }
        else if(reverse){
            reverse = false;
        }
    }
}

package moises.GameLogic;

import moises.Base.*;
import moises.Cartas.UNOCard;
import moises.Cartas.UNOSpecialCard;
import moises.Cartas.UNOWildCard;

import java.util.Arrays;

public class Juego {
    private Player[] jugadores;
    private int numjugadores;
    private Carta cartaactual;
    private int turnoactual = 0;
    private int turnomax;
    private boolean reverse = false;



    public Juego(int numJugadores) {
        inicializarJuego(numJugadores);
    }

    private void inicializarJuego(int numjugadores){

        System.out.println("Inicializando Juego");
        jugadores = new Player[numjugadores];
        System.out.println("Numero de jugadores: " + jugadores.length);
        for (int i = 0; i < jugadores.length; i++) {
            Player player = new Player("Player " + (i+1));
            jugadores[i] = player;
        }
        turnomax = jugadores.length - 1;
        System.out.println("Dando cartas a los jugadores");
        aleatorizarCartas();
    }


    private boolean realizarJugada(int cartaAjugar){
        Carta carta = jugadores[turnoactual].getCarta(cartaAjugar);
        if (cartaactual instanceof UNOCard && carta instanceof UNOCard){
            if(((UNOCard) cartaactual).getColor() == ((UNOCard) carta).getColor()){
                cartaactual = carta;
                jugadores[turnoactual].eliminarCarta(cartaAjugar);
                pasarTurno();

                return true;
            }
            else if(((UNOCard) cartaactual).getNumero() == ((UNOCard) carta).getNumero()){
                cartaactual = carta;
                return true;
            }
            else{
                System.out.println("No se cumplen los requisitos para realizar una jugada");
                return false;
            }
        }
        else if(cartaactual instanceof UNOSpecialCard && carta instanceof UNOSpecialCard){
            if(((UNOSpecialCard) cartaactual).getColor() == ((UNOSpecialCard) carta).getColor()){
                if(((UNOSpecialCard) carta).getSpecialCard() == SpecialCard.Draw_Two){
                    Carta cartauno = aleatorizarCarta();
                    Carta cartados = aleatorizarCarta();
                    drawTwoGivePlayer(cartauno, cartados);
                    cartaactual = carta;
                }
                else if(((UNOSpecialCard) carta).getSpecialCard() == SpecialCard.Skip){
                    cartaactual = carta;
                    skipFunction();

                }
                else if(((UNOSpecialCard) carta).getSpecialCard() == SpecialCard.Reverse){
                    cartaactual = carta;
                    reverseFunction();
                }
            }
        }
        else if(carta instanceof UNOWildCard){
            if (((UNOWildCard) carta).getWildCard() == WildCard.Wild){
                cartaactual = carta;


            }
        }


    }

    private void aleatorizarCartas(){
        Colores[] colores = Colores.values();
        SpecialCard[] specialCards = SpecialCard.values();
        Tipo[] tipos = Tipo.values();
        WildCard[] wildCards = WildCard.values();
        for (Player jugadores : jugadores) {
            Carta[] cartas = new Carta[7];
            for (int j = 0; j < cartas.length; j++) {
                int numrandomcolor = (int) (Math.random() * colores.length);
                int numrandomspecialcard = (int) (Math.random() * specialCards.length);
                int numrandomtipo = (int) (Math.random() * tipos.length);
                int numrandomwildcard = (int) (Math.random() * wildCards.length);
                if (tipos[numrandomtipo] == Tipo.Normal) {
                    UNOCard unoCard = new UNOCard(colores[numrandomcolor], (int) (Math.random() * 9));
                    cartas[j] = unoCard;
                } else if (tipos[numrandomtipo] == Tipo.Special) {
                    UNOSpecialCard unoSpecialCard = new UNOSpecialCard(colores[numrandomcolor], specialCards[numrandomspecialcard]);
                    cartas[j] = unoSpecialCard;
                } else if (tipos[numrandomtipo] == Tipo.Wild) {
                    UNOWildCard unoWildCard = new UNOWildCard(wildCards[numrandomwildcard]);
                    cartas[j] = unoWildCard;
                }
            }
            jugadores.setCartas(cartas);
        }
    }
    private Carta aleatorizarCarta(){

        Colores[] colores = Colores.values();
        SpecialCard[] specialCards = SpecialCard.values();
        Tipo[] tipos = Tipo.values();
        WildCard[] wildCards = WildCard.values();
        Carta cartaAleatoria;
        int numrandomcolor = (int) (Math.random() * colores.length);
        int numrandomspecialcard = (int) (Math.random() * specialCards.length);
        int numrandomtipo = (int) (Math.random() * tipos.length);
        int numrandomwildcard = (int) (Math.random() * wildCards.length);
        if (tipos[numrandomtipo] == Tipo.Normal) {
            cartaAleatoria = new UNOCard(colores[numrandomcolor], (int) (Math.random() * 9));
            return cartaAleatoria;
        } else if (tipos[numrandomtipo] == Tipo.Special) {
            cartaAleatoria = new UNOSpecialCard(colores[numrandomcolor], specialCards[numrandomspecialcard]);
            return cartaAleatoria;
        } else if (tipos[numrandomtipo] == Tipo.Wild) {
            cartaAleatoria = new UNOWildCard(wildCards[numrandomwildcard]);
            return cartaAleatoria;
        }
        return null;
    }

    private void drawTwoGivePlayer(Carta cartaUno, Carta cartaDos){
        if(turnoactual == turnomax){
            turnoactual = 0;
            jugadores[turnoactual].agregarCarta(cartaUno);
            jugadores[turnoactual].agregarCarta(cartaDos);
            System.out.println("Agregado cartas a jugador: " + turnoactual);
        }
        else{
            jugadores[turnoactual].agregarCarta(cartaUno);
            jugadores[turnoactual].agregarCarta(cartaDos);
            System.out.println("Agregado cartas a jugador: " + turnoactual);

        }
    }

    private void pasarTurno(){
        if (!reverse){
            turnoactual++;
        }
        else if(reverse){
            turnoactual--;
        }
    }

    private void skipFunction(){
        if (turnoactual == turnomax) {
            turnoactual = 1;
            System.out.println("Skipeado");
        }

        else{
            turnoactual++;
            turnoactual++;
            System.out.println("Skipeado");
        }
    }

    private void reverseFunction(){
        if(!reverse){
            reverse = true;
        }
        else if(reverse){
            reverse = false;
        }
    }




}

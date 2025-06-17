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


    public Player[] getJugadores() {
        return jugadores;
    }


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

    private boolean movimientoValido(Carta cartaAjugar,Carta cartaEnMesa ){

        if (cartaAjugar instanceof UNOWildCard){

            return true;
        }
        if (cartaAjugar instanceof UNOCard unocardjugador){
            if( cartaEnMesa instanceof UNOCard unocardactual){
                return unocardjugador.getNumero() == unocardactual.getNumero() || unocardjugador.getColor() == unocardactual.getColor();
            }
            if(cartaEnMesa instanceof UNOSpecialCard unospecialactual){
                return unocardjugador.getColor() == unospecialactual.getColor();
            }
            if (cartaEnMesa instanceof UNOWildCard unoWildCardactual){
                return unocardjugador.getColor() == unoWildCardactual.getColor();
            }
        }
        if (cartaAjugar instanceof UNOSpecialCard unocardjugador){
            if( cartaEnMesa instanceof UNOCard unocardactual){
                return unocardjugador.getColor() == unocardactual.getColor();
            }
            if(cartaEnMesa instanceof UNOSpecialCard unospecialactual){
                return unocardjugador.getColor() == unospecialactual.getColor() || unocardjugador.getSpecialCard() == unospecialactual.getSpecialCard();
            }
            if (cartaEnMesa instanceof UNOWildCard unowildactual){
                return unocardjugador.getColor() == unowildactual.getColor();
            }
        }

        return false;
    }


    private boolean realizarJugada(int cartaAjugar, Colores colorElegido){
        Carta carta = jugadores[turnoactual].getCarta(cartaAjugar);
        if (!movimientoValido(carta,cartaactual)){
            System.out.println("No se pudo realizar la jugada");
            return false;
        }

        if (carta instanceof UNOCard){
            pasarCarta(carta,cartaAjugar);
            pasarTurno();
        }
        if (carta instanceof UNOSpecialCard cartajugadorspecial){
            switch (cartajugadorspecial.getSpecialCard()){
                case Draw_Two:
                    drawTwoGivePlayer(aleatorizarCarta(),aleatorizarCarta());
                    pasarCarta(carta,cartaAjugar);
                    break;
                case Reverse:
                    reverseFunction();
                    pasarCarta(carta,cartaAjugar);
                    break;
                case Skip:
                    skipFunction();
                    pasarCarta(carta,cartaAjugar);
                    break;
            }
        }
        if (carta instanceof UNOWildCard cartajugadorwild){

            if (colorElegido == null){
                System.out.println("Color no seleccionado");
                return false;
            }
            cartajugadorwild.setColor(colorElegido);
            if (cartajugadorwild.getWildCard() == WildCard.Wild){
                pasarCarta(carta,cartaAjugar);
            }

            if(cartajugadorwild.getWildCard() == WildCard.Wild_Draw_Four){
                drawFourGivePlayer(aleatorizarCarta(),aleatorizarCarta(),aleatorizarCarta(),aleatorizarCarta());
                pasarCarta(carta,cartaAjugar);
            }
        }

        System.out.println("Jugada realizada con exito");
        return true;
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
        jugadores[turnoactual].agregarCarta(cartaUno);
        jugadores[turnoactual].agregarCarta(cartaDos);
        System.out.println("Agregando carta para jugador: " + turnoactual);
        pasarTurno();
    }
    private void drawFourGivePlayer(Carta cartaUno, Carta cartaDos,Carta cartaTres, Carta cartaCuatro){
        jugadores[turnoactual].agregarCarta(cartaUno);
        jugadores[turnoactual].agregarCarta(cartaDos);
        jugadores[turnoactual].agregarCarta(cartaTres);
        jugadores[turnoactual].agregarCarta(cartaCuatro);
        System.out.println("Agregado cartas a jugador: " + turnoactual);
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

    private void pasarCarta(Carta carta, int cartapos){
        cartaactual = carta;
        jugadores[turnoactual].eliminarCarta(cartapos);
    }


    private void skipFunction(){
        pasarTurno();
        pasarTurno();

    }

    private void reverseFunction(){
        if(!reverse){
            reverse = true;
            pasarTurno();
        }
        else if(reverse){
            reverse = false;
            pasarTurno();
        }
    }




}

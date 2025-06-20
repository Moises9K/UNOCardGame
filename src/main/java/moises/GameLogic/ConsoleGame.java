package moises.GameLogic;

public class ConsoleGame {

    private Juego juego;

    public ConsoleGame(Juego juego){
        this.juego = juego;
    }

    public void iniciarJuego(){
        while(true){

            juego.realizarJugada();
        }
    }

}

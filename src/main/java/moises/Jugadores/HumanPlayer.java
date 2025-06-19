package moises.Jugadores;

import moises.Base.Player;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int jugarCarta() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Turno de " + getName());
        System.out.println("Escoga una carta para jugar:");
        for (int i = 0; i< super.getCartas().size(); i++){
            StringBuffer sb = new StringBuffer();
            sb.append("Carta ").append(i+1).append(" : ").append(super.getCartas().get(i).getName());
            System.out.println(sb);
        }
        int choice;
        while(true){
            if(sc.hasNextInt()){
                choice = sc.nextInt() - 1;
                if(choice > super.getCartas().size()-1) {
                    System.out.println("Numero invalido para jugar");
                    sc.next();
                }
                else{
                    break;
                }
            }
            else{
                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }
        return choice;
    }
}

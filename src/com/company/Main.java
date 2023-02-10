package com.company;

import java.util.*;

public class Main {
    TicTacToe game = new TicTacToe();
    //Main
    public void main(String[] args) {
        game.chooseTeam();
        game.initField();

        // Loop, bis gewonnen oder unentschieden
        while(!game.checkHorizontal() && !game.checkVertical() && !game.checkCross() && !game.checkTie()){
            game.showField();
            // Zug machen
            if(turn%2 == 0){
                System.out.println("Du bist am Zug!");
                setField(player1);
            }
            else{
                System.out.println("Computer ist am Zug!");
                game.setField(computer);
            }
        }
        game.showField();
        if(won && winner.equals("Spieler 1"))
            System.out.println("Glückwunsch! Du hast gewonnen!");
        if(won && winner.equals("Computer"))
            System.out.println("Schade! Du hast leider verloren...!");
        if(!won)
            System.out.println("Unentschieden! Keiner konnte die Partie für sich entscheiden...");


    }
}

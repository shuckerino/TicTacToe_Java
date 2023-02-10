package com.company;

import java.util.*;

public class Main {
    private static TicTacToe game = new TicTacToe();
    //Main
    public static void main(String[] args) {
        game.chooseTeam();
        game.initField();

        // Loop, bis gewonnen oder unentschieden
        while(!game.checkHorizontal() && !game.checkVertical() && !game.checkCross() && !game.checkTie()){
            // Zug machen
            if(game.getTurn()%2 == 0){
                game.showField();
                System.out.println("Du bist am Zug!");
                game.setField(game.getPlayer1());
            }
            else{
                game.setField(game.getComputer());
            }
        }
        game.showField();
        if(game.getWon() && game.getWinner().equals("Spieler 1"))
            System.out.println("Glückwunsch! Du hast gewonnen!");
        if(game.getWon() && game.getWinner().equals("Computer"))
            System.out.println("Schade! Du hast leider verloren...!");
        if(!game.getWon())
            System.out.println("Unentschieden! Keiner konnte die Partie für sich entscheiden...");


    }
}

package com.company;

import java.util.*;

public class Main {
    //Main
    //TODO implement random turns (random who actually starts)
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        GUI gui = new GUI(game.getPlayerTurn(), game.getPlayer1(), game.getComputer());
        game.chooseTeam();
        game.initField();

        // Loop, bis gewonnen oder unentschieden
        while(!game.checkHorizontal() && !game.checkVertical() && !game.checkCross() && !game.checkTie()){
            // Spieler ändern
            game.nextTurn();
            // Zug machen
            if(game.getPlayerTurn()){
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

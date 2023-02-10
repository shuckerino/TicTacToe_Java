package com.company;

import java.util.*;


public class TicTacToe {
    // Globale Variablen
    int turn;
    Scanner sc  = new Scanner(System.in);
    char[][] field;
    boolean won;
    String winner;
    char player1, computer;



    TicTacToe(){
        this.turn = 0;
        this.field = new char[3][3];
        this.won = false;
        this.winner = "";
    }



    // Methoden für Spielfeld

    public void setField (char player){
        int pos;
        boolean invalid = false;

        do{
            // Feld abfragen
            if(player == player1){
                System.out.println("Wo möchtest du setzen?");
                pos = sc.nextInt();
            }
            else{
                pos = (int) (Math.random() * 9);
            }

            if((pos >0 && pos < 10)){
                if(pos == 1 && field[0][0] == '-'){
                    field[0][0] = player;
                    break;
                }

                if(pos == 2 && field[0][1] == '-') {
                    field[0][1] = player;
                    break;
                }
                if(pos == 3 && field[0][2] == '-') {
                    field[0][2] = player;
                    break;
                }
                if(pos == 4 && field[1][0] == '-') {
                    field[1][0] = player;
                    break;
                }
                if(pos == 5 && field[1][1] == '-') {
                    field[1][1] = player;
                    break;
                }
                if(pos == 6 && field[1][2] == '-') {
                    field[1][2] = player;
                    break;
                }
                if(pos == 7 && field[2][0] == '-') {
                    field[2][0] = player;
                    break;
                }
                if(pos == 8 && field[2][1] == '-') {
                    field[2][1] = player;
                    break;
                }
                if(pos == 9 && field[2][2] == '-') {
                    field[2][2] = player;
                    break;
                }
                else{
                    invalid = true;
                    if(turn%2 == 0)
                        System.out.println("Feld besetzt!");
                }

            }
            else{
                invalid = true;
                if(turn%2 == 0)
                    System.out.println("Ungültiges Feld");

            }

        }while(invalid);

        turn++; // nächster Zug
    }

    public void showField(){
        // Spielfeld ausgeben
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                System.out.print(field[i][j] + " | ");
            System.out.println("\n-----------");
        }
    }

    public void chooseTeam() {
        boolean valid = false; // für Eingabe der Teams

        // Team wählen
        //TODO exception handling falsche eingabe
        do {
            System.out.println("Wähle o oder x: ");
            player1 = sc.next().charAt(0);
            if (player1 == 'x' || player1 == 'o')
                valid = true;
            if (player1 == 'x') {
                computer = 'o';
            } else {
                computer = 'x';
            }

        } while (!valid);
    }

    public void initField(){
        // Spielfeld initialisieren
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                field[i][j] = '-';
            }
    }

    // Methoden für Spiellogik

    public boolean checkHorizontal() {
        // 1. Reihe
        if (field[0][0] == field[0][1] && field[0][0] == field[0][2] && field[0][0] != '-') {
            won = true;
            if (field[0][0] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        // 2. Reihe
        if (field[1][0] == field[1][1] && field[1][0] == field[1][2] && field[1][0] != '-') {
            won = true;
            if (field[1][0] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        // 3. Reihe
        if (field[2][0] == field[2][1] && field[2][0] == field[2][2] && field[2][0] != '-') {
            won = true;
            if (field[2][0] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        return won;
    }

    public boolean checkVertical() {
        // 1. Spalte
        if (field[0][0] == field[1][0] && field[0][0] == field[2][0] && field[0][0] != '-') {
            won = true;
            if (field[0][0] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        // 2. Spalte
        if (field[0][1] == field[1][1] && field[0][1] == field[2][1] && field[0][1] != '-') {
            won = true;
            if (field[0][1] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        // 3. Spalte
        if (field[0][2] == field[1][2] && field[0][2] == field[2][2] && field[0][2] != '-') {
            won = true;
            if (field[0][2] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        return won;
    }

    public boolean checkCross(){
        // Linksdiagonal
        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != '-') {
            won = true;
            if (field[0][0] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }

        // Rechtsdiagonal
        if (field[2][0] == field[1][1] && field[2][0] == field[0][2] && field[2][0] != '-') {
            won = true;
            if (field[0][1] == player1)
                winner = "Spieler 1";
            else
                winner = "Computer";
        }
        return won;
    }

    public boolean checkTie(){
        int countEmptyFields = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                if(field[i][j] == '-'){
                    countEmptyFields++;
                };
            }
        return (countEmptyFields == 0);
    }


}
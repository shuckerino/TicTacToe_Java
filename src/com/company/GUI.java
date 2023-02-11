package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {

    JFrame frame;
    Container c;
    JPanel title_panel;
    JPanel button_panel;
    JLabel text_field;
    JButton[] buttons;
    private boolean player_turn;
    private char player_symbol, computer_symbol;


    GUI(boolean player_turn, char p_symbol, char c_symbol){
        this.player_turn = player_turn;
        this.player_symbol = p_symbol;
        this.computer_symbol = c_symbol;

        // Frame
        frame = new JFrame();
        frame.setSize(800,800);
        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50, 50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Textfeld
        text_field = new JLabel();
        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(255, 25, 25));
        text_field.setFont(new Font("Ink Free",Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("TicTacToe");
        text_field.setOpaque(true);

//        // Container
//        c = frame.getContentPane();
//        c.setLayout(new GridLayout(3, 3));
//        c.setVisible(true);

        // Panels
        title_panel = new JPanel();
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800, 100);
        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH); // adding title_panel to the frame


        // Button Panel
        buttons = new JButton[9];
        button_panel = new JPanel();

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(25,255,25));
        frame.add(button_panel); // adding button_panel to frame

        // Buttons

        // Create 9 buttons
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.ITALIC, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }



    }

    protected void nextTurn(){
        if(player_turn) {
            if(player_symbol == 'X')
                text_field.setText("O ist dran!");
            if(player_symbol == 'O')
                text_field.setText("X ist dran!");
            player_turn = false;
        }
        else {
            if(computer_symbol == 'X')
                text_field.setText("O ist dran!");
            if(computer_symbol == 'O')
                text_field.setText("X ist dran!");
            player_turn = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Checking all 9 buttons
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("" + player_symbol);
                        nextTurn();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("" + computer_symbol);
                        nextTurn();
                    }
                }

            }

        }
    }
}

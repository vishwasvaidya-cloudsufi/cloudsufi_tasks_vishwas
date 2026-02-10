package com.example.pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
// Like a frame of painting contains minimize, maximize and close button...
public class GameFrame extends JFrame{

    GamePanel panel;

    GameFrame(){
        panel  = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(true);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Automatically resizes the window according to our game
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

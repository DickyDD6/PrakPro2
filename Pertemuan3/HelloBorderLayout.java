/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import sun.applet.Main;

public class HelloBorderLayout extends JFrame {
    public HelloBorderLayout(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia?");
        JLabel labelHasil = new JLabel("Jawab pertanyaan di atas");
        
        JButton buttonA = new JButton("Jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Surabaya");
        
        buttonA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawa anda benar");
            }
        });
        buttonB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawa anda salah");
            }
        });
        buttonC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawa anda salah");
            }
        });
        
        this.add(labelPertanyaan, BorderLayout.NORTH);
        this.add(labelHasil, BorderLayout.SOUTH);
        this.add(buttonA, BorderLayout.WEST);
        this.add(buttonB, BorderLayout.CENTER);
        this.add(buttonC, BorderLayout.EAST);
        this.setSize(500,300);
        
    }
    public static void main(String[]args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                HelloBorderLayout h = new HelloBorderLayout();
                h.setVisible(true);
            }
        });
    }
}

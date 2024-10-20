/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloGridLayout extends JFrame implements ActionListener {
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;
    private JButton[] buttons;
    private boolean gameOver;
    
    public HelloGridLayout(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameOver = false;
        
        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");
        
        buttons = new JButton[9];
        buttons[0]= buttonA;
        buttons[1]= buttonB;
        buttons[2]= buttonC;
        buttons[3]= buttonD;
        buttons[4]= buttonE;
        buttons[5]= buttonF;
        buttons[6]= buttonG;
        buttons[7]= buttonH;
        buttons[8]= buttonI;
        
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonG.addActionListener(this);
        buttonH.addActionListener(this);
        buttonI.addActionListener(this);
        
        this.setLayout(new GridLayout(3,3));
        
        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);
        this.add(buttonE);
        this.add(buttonF);
        this.add(buttonG);
        this.add(buttonH);
        this.add(buttonI);
        
        this.setSize(400,400);
    }
    public void actionPerformed(ActionEvent e){
        if (!gameOver){
            JButton button = (JButton) e.getSource();
            if(button.getText().isEmpty())
            {
                button.setText("O");
                checkWinner();
                if (!gameOver)
                {
                    for(int i = 0; i< buttons.length;i++)
                    {
                        if (buttons[i].getText().isEmpty())
                        {
                            buttons[i].setText("X");
                            break;
                        }
                    }
                    checkWinner();
                }
            }
        }
    } 
            private void checkWinner()
            {
                String winner = "";
                if(!buttonA.getText().isEmpty()
                    && buttonA.getText().equals(buttonB.getText())
                    && buttonA.getText().equals(buttonC.getText()))
            {
                winner = buttonA.getText();
                buttonA.setForeground(Color.red);
                buttonB.setForeground(Color.red);
                buttonC.setForeground(Color.red);
            } else if(!buttonD.getText().isEmpty()
                    && buttonD.getText().equals(buttonE.getText())
                    && buttonD.getText().equals(buttonF.getText()))
            {
                winner = buttonD.getText();
                buttonD.setForeground(Color.red);
                buttonB.setForeground(Color.red);
                buttonC.setForeground(Color.red);
            }else if(!buttonG.getText().isEmpty()
                    && buttonG.getText().equals(buttonH.getText())
                    && buttonG.getText().equals(buttonI.getText()))
            {
                winner = buttonG.getText();
                buttonG.setForeground(Color.red);
                buttonH.setForeground(Color.red);
                buttonI.setForeground(Color.red);
            }else if(!buttonA.getText().isEmpty()
                    && buttonA.getText().equals(buttonD.getText())
                    && buttonA.getText().equals(buttonG.getText()))
            {
                winner = buttonA.getText();
                buttonA.setForeground(Color.red);
                buttonD.setForeground(Color.red);
                buttonG.setForeground(Color.red);
            }else if(!buttonB.getText().isEmpty()
                    && buttonB.getText().equals(buttonE.getText())
                    && buttonB.getText().equals(buttonH.getText()))
            {
                winner = buttonB.getText();
                buttonB.setForeground(Color.red);
                buttonE.setForeground(Color.red);
                buttonH.setForeground(Color.red);
            }else if(!buttonC.getText().isEmpty()
                    && buttonC.getText().equals(buttonF.getText())
                    && buttonC.getText().equals(buttonI.getText()))
            {
                winner = buttonC.getText();
                buttonC.setForeground(Color.red);
                buttonF.setForeground(Color.red);
                buttonI.setForeground(Color.red);
            }else if(!buttonA.getText().isEmpty()
                    && buttonA.getText().equals(buttonE.getText())
                    && buttonA.getText().equals(buttonI.getText()))
            {
                winner = buttonA.getText();
                buttonA.setForeground(Color.red);
                buttonE.setForeground(Color.red);
                buttonI.setForeground(Color.red);
            }else if(!buttonC.getText().isEmpty()
                    && buttonC.getText().equals(buttonE.getText())
                    && buttonC.getText().equals(buttonG.getText()))
            {
                winner = buttonC.getText();
                buttonC.setForeground(Color.red);
                buttonE.setForeground(Color.red);
                buttonG.setForeground(Color.red);
            }
                gameOver = !winner.isEmpty();
    }
            public static void main(String[]args){
                javax.swing.SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        HelloGridLayout h = new HelloGridLayout();
                        h.setVisible(true);
                    }
                });
            }
}

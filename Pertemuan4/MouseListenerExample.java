/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan4;

/**
 *
 * @author ASUS
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseListener Esample");
        
        //membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");
        label.setBounds(50, 50, 300, 30);
        
        //menambahkan MouseListener ke label
        label.addMouseListener(new MouseListener(){
            //dijalankan ketika mouse diklik{klik kiri , klik kanan atau tengah}
            public void mouseClicked(MouseEvent e){
                label.setText("Mouse Clicked at: (" +e.getX()+ "," + e.getY()+")");
                
            }
            //dijalankan ketika mouse ditekan(tanpa dilepaskan)
            public void mousePressed(MouseEvent e){
                label.setText("Mouse Presed at: ("+ e.getX()+","+ e.getY()+")");
                
            }
            
            //dijalankan ketika mouse dilepaskan setelah ditekan
            public void mouseReleased(MouseEvent e){
                label.setText("Mouse Presed at: ("+ e.getX()+","+ e.getY()+")");
            }
            
            //dijalankan ketika mouse masuk ke area komponen
            @Override
            public void mouseEntered(MouseEvent e){
                label.setText("Mouse Entered the area.");
            }
            
            //dijalnkan ketika mouse keluar dari komponen
            public void mouseExited(MouseEvent e){
                label.setText("Mouses exited the area.");
            }
        });
        
        //menambahkan label ke frame
        frame.add(label);
        
        //setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

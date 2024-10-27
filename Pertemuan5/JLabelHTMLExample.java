/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan5;

/**
 *
 * @author ASUS
 */
import javax.swing.*;
public class JLabelHTMLExample {
 public static void main(String[] args) {
 JFrame frame = new JFrame("JLabel HTML Example");
 // Membuat JLabel dengan teks HTML
 JLabel label = new JLabel("<html><b>Bold Text</b>, <i>Italic Text</i>,and <u>Underlined Text</u></html>");
 // Menambahkan JLabel ke JFrame
 frame.add(label);
 // Konfigurasi frame
 frame.setSize(300, 100);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);
 }
}


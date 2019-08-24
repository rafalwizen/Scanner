/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Rafał
 */
public class Scaner extends JFrame implements ActionListener {

    public Scaner() {
        //JFrame frame = new JFrame();
        //

        initComponents();

        this.setBounds(100, 100, 200, 400);
        //  this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    Actions action = new Actions();
    JPanel panel = new JPanel(new FlowLayout());
   // JButton start = new JButton("Start");
    JButton zapisz = new JButton("Zapisz");
    JTextField wprowadzanie = new JTextField();
    JTextArea wynik = new JTextArea();

    public void initComponents() {
        wprowadzanie.setPreferredSize(new Dimension(100, 20));
        panel.add(wprowadzanie);
        wprowadzanie.addActionListener(this);
      //  start.setPreferredSize(new Dimension(100, 20));
      //  panel.add(start);
      //  start.addActionListener(this);
        zapisz.setPreferredSize(new Dimension(100, 20));
        panel.add(zapisz);
        zapisz.addActionListener(this);
        wynik.setPreferredSize(new Dimension(100, 200));
        panel.add(wynik);

        this.getContentPane().add(panel, FlowLayout.LEFT);

        //Thread controller = new Thread(new Controller());
        //controller.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String text = "";
        if (source == zapisz) {
            text = wynik.getText();
            action.zapisz(text);
        }
    }

    public void setWynik(String wynik_) {
        String i = wynik.getText();
        wynik.setText(wynik_ + "\r\n" + i);               //.setText
    }

    public void getWprowadzanieLength() {
        if (wprowadzanie.getText().length() == 13) {
            try {
                setWynik(wprowadzanie.getText());
                wprowadzanie.setText("");
                Thread.sleep(1000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Scaner.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Scaner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        Scaner scaner = new Scaner();
        Thread controller = new Thread(new Controller(scaner));
        controller.start();
    }

}

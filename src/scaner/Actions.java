/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Rafał
 */
public class Actions extends JPanel implements ActionListener {

    
    public void zapisz(String text) {
        try {
            FileWriter file = new FileWriter("Kody.txt");
            BufferedWriter bufor1 = new BufferedWriter(file);
            file.write(text);
            file.close();
        } catch (IOException e) {
            System.err.println("Blad IO byte1 " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

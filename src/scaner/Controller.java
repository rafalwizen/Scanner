/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scaner;

/**
 *
 * @author Rafał
 */
public class Controller implements Runnable {

    Scaner help;

    public Controller(Scaner help) {
        this.help = help;
    }

    @Override
    public void run() {
        while (true) {
            help.getWprowadzanieLength();
        }
    }

}

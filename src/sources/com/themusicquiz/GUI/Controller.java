/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:49:34 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-25 12:05:48
 */
package com.themusicquiz.GUI;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Controller implements EventHandler<ActionEvent> {
    Gui gui;

    public Controller(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        Object cmd = event.getSource();
    }
}
/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:54:08 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-25 12:05:09
 */

package com.themusicquiz.GUI;

public class Main extends Gui{

    public static void main(String[] args) {
        launch(args);
        Gui gui = new Gui();
        Controller control = new Controller(gui);
    }
}
/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 15:35:50 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 15:58:27
 */
package com.themusicquiz.GUI;

import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.util.ArrayList;

public class NodeGetter {

    public static ArrayList<Button> getAllButtons(Parent root) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        addAllDescendents(root, buttons);
        return buttons;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Button> buttons) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if(node instanceof Button) {
                buttons.add((Button) node);
                if (node instanceof Parent)
                    addAllDescendents((Parent)node, buttons);
            }
        }
    }

}

/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 13:37:03 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 13:59:44
 */
package com.themusicquiz.GUI;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;

public class SceneApp extends Scene {
    private static final int percentage = 100;
    private static final int vgap = 0;
    private static final int hgap = 0;
    private static final int insetsParameter = 1;

    public SceneApp() {
        super(new GridPane(), Constantes.WINDOW_WIDTH.getValue(), Constantes.WINDOW_HEIGHT.getValue());
    }

    public GridPane createGridPaneWithConstraints(int pNumberOfColumns, int pNumberOfRows) {
        GridPane grid = new GridPane();
        Double columnsPercentWidth = (double) percentage / pNumberOfColumns;
        Double rowsPercentHeight = (double) percentage / pNumberOfRows;
        grid.setHgap(hgap);
        grid.setVgap(vgap);
        grid.setPadding(new Insets(insetsParameter, insetsParameter, insetsParameter, insetsParameter));
        for(int i = 0; i<pNumberOfColumns; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(columnsPercentWidth);
            column.setHgrow(Priority.ALWAYS);
            column.setFillWidth(true);
            grid.getColumnConstraints().add(column);
        }
        for(int i = 0; i<pNumberOfRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(rowsPercentHeight);
            row.setVgrow(Priority.ALWAYS);
            row.setFillHeight(true);
            grid.getRowConstraints().add(row);
        }
        return grid;
    }
}
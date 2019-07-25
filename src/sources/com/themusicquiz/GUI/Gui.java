/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-25 11:52:11 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-25 18:17:15
 */
package com.themusicquiz.GUI;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;

public class Gui extends Application {

    private static final int insetsParameter = 1;
    private static final int columnNumber = 10;
    private static final int vgap = 0;
    private static final int hgap = 0;
    private static final int percentage = 100;

    private Stage window;
    private Scene welcomeScene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        try {
            welcomeScene = CreateWelcomeScene();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        window.setScene(welcomeScene);
        window.setTitle("The Music Quiz");
        window.show();
    }

    private Scene CreateWelcomeScene() throws FileNotFoundException {
        GridPane grid = createGridPaneWithConstraints(1, 10);
        //grid.setGridLinesVisible(true);

        Label mainTitle = new Label("The Music Quiz");
        mainTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        mainTitle.setAlignment(Pos.CENTER);
        mainTitle.setId("main_title");
        grid.add(mainTitle, 0, 1, 1, 2);

        Label createdBy = new Label("Created by Alexandre Ladrière\n2019");
        createdBy.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        createdBy.setAlignment(Pos.CENTER);
        createdBy.setTextAlignment(TextAlignment.CENTER);
        createdBy.setId("created_by");
        grid.add(createdBy, 0, 9);

        Image appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 143, 143, false, false);
        Label appLogoLabel = new Label();
        appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        appLogoLabel.setGraphic(new ImageView(appLogo));
        appLogoLabel.setAlignment(Pos.CENTER);
        grid.add(appLogoLabel, 0, 4, 1, 2);

        Scene scene = new Scene(grid, Constantes.WINDOW_WIDTH.getValue(), Constantes.WINDOW_HEIGHT.getValue());
        scene.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
        return scene;
    }

    private GridPane createGridPaneWithConstraints(int pNumberOfColumns, int pNumberOfRows) {
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
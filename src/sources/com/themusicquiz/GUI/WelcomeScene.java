/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-26 14:04:20 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 14:11:55
 */
package com.themusicquiz.GUI;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.themusicquiz.enumerations.Constantes;
import com.themusicquiz.enumerations.Paths;

public class WelcomeScene extends SceneApp {
    
    private GridPane grid;
    private Label mainTitle;
    private Label createdBy;
    private Image appLogo;
    private Label appLogoLabel;

    public WelcomeScene() throws FileNotFoundException {
        super();
        this.grid = super.createGridPaneWithConstraints(1, 10);
        super.setRoot(grid);
        //grid.setGridLinesVisible(true);

        this.mainTitle = new Label("The Music Quiz");
        this.mainTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.mainTitle.setAlignment(Pos.CENTER);
        this.mainTitle.setId("main_title");
        this.grid.add(mainTitle, 0, 1, 1, 2);

        this.createdBy = new Label("Created by Alexandre Ladrière\n2019");
        this.createdBy.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.createdBy.setAlignment(Pos.CENTER);
        this.createdBy.setTextAlignment(TextAlignment.CENTER);
        this.createdBy.setId("created_by");
        this.grid.add(createdBy, 0, 9);

        this.appLogo = new Image(new FileInputStream(Paths.ALBUM_ICON.getPath()), 143, 143, true, true);
        this.appLogoLabel = new Label();
        this.appLogoLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.appLogoLabel.setGraphic(new ImageView(appLogo));
        this.appLogoLabel.setAlignment(Pos.CENTER);
        this.grid.add(appLogoLabel, 0, 4, 1, 2);

        this.getStylesheets().add("file:"+Paths.CSS_THEME_PATH.getPath());
    }
}
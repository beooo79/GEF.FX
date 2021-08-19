package de.gef.fx;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloFX extends Application {

    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        var label = new Label(
                "Manage your gear, energy, finances.\n" + "Java: " + javaVersion + "\nJavaFx: " + javafxVersion);
        var logo = new ImageView(new Image(HelloFX.class.getResourceAsStream("geffx.png")));
        var logoLabel = new HBox(30, logo, label);
        var toolBar = new ToolBar();
        var splitPane = new SplitPane();
        var scene = new Scene(splitPane, 1200, 800);
        var scrollPane = new ScrollPane();
        var table = new TableView<List<String>>();

        table.setUserData(buildList());
        splitPane.setOrientation(Orientation.VERTICAL);
        scrollPane.setContent(table);
        toolBar.getItems().addAll(logo, logoLabel);
        splitPane.setDividerPositions(0.1);
        splitPane.getItems().addAll(toolBar, scrollPane);

        logo.setFitHeight(200);
        logo.setPreserveRatio(true);
        scene.getStylesheets().add(HelloFX.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private List<String> buildList() {
        return List.of("Hello", "World", "item3");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
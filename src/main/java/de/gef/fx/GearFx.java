package de.gef.fx;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GearFx extends Application {

    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        var label = new Label(
                "Manage your gear, energy, finances.\n" + "Java: " + javaVersion + "\nJavaFx: " + javafxVersion);
        var logo = new ImageView(new Image(GearFx.class.getResourceAsStream("geffx.png")));
        var logoLabel = new HBox(30, logo, label);
        var toolBar = new ToolBar();
        var splitPane = new SplitPane();
        var scene = new Scene(splitPane, 1200, 800);
        var scrollPane = new ScrollPane();
        var table = new TableView<Gear>();

        addColumnData(table);
        addGearData(table);
        splitPane.setOrientation(Orientation.VERTICAL);
        scrollPane.setContent(table);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        toolBar.getItems().addAll(logo, logoLabel);
        splitPane.setDividerPositions(0.1);
        splitPane.getItems().addAll(toolBar, scrollPane);
        logo.setFitHeight(100);
        logo.setPreserveRatio(true);
        scene.getStylesheets().add(GearFx.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("GEF.FX");
        stage.show();
    }

    private void addColumnData(TableView<Gear> table) {
        var col1 = new TableColumn<Gear, String>("id");
        col1.setCellValueFactory(new PropertyValueFactory("id"));
        var col2 = new TableColumn<Gear, String>("description");
        col2.setCellValueFactory(new PropertyValueFactory("description"));

        table.getColumns().setAll(col1, col2);
    }

    private void addGearData(TableView<Gear> table) {
        var data = List.of(Gear.builder().id(1).currentValue(BigDecimal.valueOf(12.23))
                .acquisitionCost(BigDecimal.valueOf(29.99)).description("Nitecore").date(ZonedDateTime.now()).build());
        var obsData = FXCollections.unmodifiableObservableList(FXCollections.observableArrayList(data));
        table.setItems(obsData);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
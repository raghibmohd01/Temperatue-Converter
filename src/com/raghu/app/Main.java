package com.raghu.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Temperature Converter");

        MenuBar menuBar=createMenu();
        root.getChildren().add(0,menuBar);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public MenuBar createMenu()
    {
        MenuBar menuBar=new MenuBar();
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
       //file menu
        Menu fileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");
        MenuItem quitMenuItem=new MenuItem("Quit");
        fileMenu.getItems().addAll(newMenuItem,quitMenuItem);

        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        //help menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutMenuItem=new MenuItem("About Application");
        MenuItem aboutUsMenuItem=new MenuItem("About Developer");
        MenuItem updateMenuItem=new MenuItem("Check for Updates");
        helpMenu.getItems().addAll(aboutMenuItem,updateMenuItem,separatorMenuItem,aboutUsMenuItem);

        aboutUsMenuItem.setOnAction(event ->{

            Alert alertAboutUs=new Alert(Alert.AlertType.INFORMATION);
            alertAboutUs.setTitle("About Me");
            alertAboutUs.setHeaderText("Raghib IT Solutions");
            alertAboutUs.setContentText("Hi there, \nI am Mohammad Raghib, an egineering student at SLIET. This is my first project in java.");


            alertAboutUs.show();

                });

        //edit menu
        //Menu editMenu=new Menu("Edit");


        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

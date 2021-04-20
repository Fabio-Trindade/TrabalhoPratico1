package main;

import javafx.application.Application;
import javafx.stage.Stage;
import models.entidades.ProdutoVendido;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    MainController controller=  MainController.getInstance();

    public static void main(String[] args) {


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       controller.initApp(primaryStage);
    }
}

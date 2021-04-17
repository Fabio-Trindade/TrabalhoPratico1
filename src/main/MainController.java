package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import views.cadastrarClienteView.CadastrarClienteView;
import views.cadastrarProdutoView.CadastrarProdutoView;
import views.menuView.MenuView;
import views.menuView.MenuViewController;



public class MainController {
    private static final MainController controllerMain = new MainController();
    private MainController(){}
    public static Stage windows;
    public static Scene menuView, cadastrarProdutoView,cadastrarClienteView;

    MenuViewController controllerMenuView= MenuViewController.getInstance();

    public static MainController getInstance() {
        return controllerMain;
    }

    private void initScenes(){
        menuView = new MenuView().getSceneMenuView();
        cadastrarProdutoView=new CadastrarProdutoView().getSceneCadastrarProduto();
        cadastrarClienteView=new CadastrarClienteView().getSceneCadastrarProduto();

    }
    private void initOnClicks(){
        controllerMenuView.botaoCadastrarProduto.setOnAction(e -> windows.setScene(cadastrarProdutoView));
        controllerMenuView.botaoCadastrarCliente.setOnAction(e -> windows.setScene(cadastrarClienteView));


    }



    public void initApp(Stage primaryStage){
        initOnClicks();
        initScenes();
        windows = primaryStage;
        windows.setScene( MainController.menuView);
        windows.show();
        windows.setTitle("GestãoComercialApp");
        windows.setAlwaysOnTop(true);
    }


}

package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import views.altrerarEstoqueView.AlterarEstoqueView;
import views.cadastrarClienteView.CadastrarClienteView;
import views.cadastrarProdutoView.CadastrarProdutoView;
import views.menuView.MenuView;
import views.menuView.MenuViewController;
import views.realizarVendaView.RealizarVendaView;


public class MainController {
    private static final MainController controllerMain = new MainController();
    private MainController(){}
    public static Stage windows;
    public static Scene menuView, cadastrarProdutoView,cadastrarClienteView,
    realizarVendaView,alterarEstoqueView;

    MenuViewController controllerMenuView= MenuViewController.getInstance();

    public static MainController getInstance() {
        return controllerMain;
    }

    private void initScenes(){
        menuView = new MenuView().getSceneMenuView();
        cadastrarProdutoView=new CadastrarProdutoView().getSceneCadastrarProduto();
        cadastrarClienteView=new CadastrarClienteView().getSceneCadastrarProduto();
        realizarVendaView = new RealizarVendaView().getSceneRealizarVenda();
        alterarEstoqueView = new AlterarEstoqueView().getScene();

    }
    private void initOnClicks(){
        controllerMenuView.botaoCadastrarProduto.setOnAction(e -> windows.setScene(cadastrarProdutoView));
        controllerMenuView.botaoCadastrarCliente.setOnAction(e -> windows.setScene(cadastrarClienteView));
        controllerMenuView.botaoRealizarVenda.setOnAction(e -> windows.setScene(realizarVendaView));
        controllerMenuView.botaoAlterarEstoque.setOnAction(e->windows.setScene(alterarEstoqueView));


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

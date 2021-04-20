package main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import views.alterarClienteView.AlterarClienteView;
import views.alterarStatusDeVendaView.AlterarStatusView;
import views.altrerarEstoqueView.AlterarEstoqueView;
import views.cadastrarClienteView.CadastrarClienteView;
import views.cadastrarProdutoView.CadastrarProdutoView;
import views.listarClientesView.ListaCLienteViewController;
import views.listarClientesView.ListarClienteView;
import views.listarProdutosView.ListarProdutosView;
import views.listarProdutosView.ListarProdutosViewController;
import views.listarVendasView.ListarVendaView;
import views.listarVendasView.ListarVendaViewController;
import views.menuView.MenuView;
import views.menuView.MenuViewController;
import views.realizarVendaView.RealizarVendaView;


public class MainController {
    private static final MainController controllerMain = new MainController();
    private MainController(){}
    public static Stage windows;
    public static Scene menuView, cadastrarProdutoView,cadastrarClienteView,
    realizarVendaView,alterarEstoqueView,alterarClienteView,alterarStatusView,
    listarClientes,listarVendas,listarProdutos;

    MenuViewController controllerMenuView= MenuViewController.getInstance();

    public static MainController getInstance() {
        return controllerMain;
    }

    private void initScenes(){
        menuView = new MenuView().getSceneMenuView();
        cadastrarProdutoView= new CadastrarProdutoView().getSceneCadastrarProduto();
        cadastrarClienteView= new CadastrarClienteView().getSceneCadastrarProduto();
        realizarVendaView = new RealizarVendaView().getSceneRealizarVenda();
        alterarEstoqueView = new AlterarEstoqueView().getScene();
        alterarClienteView= new AlterarClienteView().getScene();
        alterarStatusView= new AlterarStatusView().getScene();
        listarClientes =  new ListarClienteView().getScene();
        listarVendas=new ListarVendaView().getScene();
        listarProdutos=new ListarProdutosView().getScene();

    }
    private void initOnClicks(){
        controllerMenuView.botaoSair.setOnAction(e->{
            System.exit(0);
        });
        controllerMenuView.botaoCadastrarProduto.setOnAction(e -> windows.setScene(cadastrarProdutoView));
        controllerMenuView.botaoCadastrarCliente.setOnAction(e -> windows.setScene(cadastrarClienteView));
        controllerMenuView.botaoRealizarVenda.setOnAction(e -> windows.setScene(realizarVendaView));
        controllerMenuView.botaoAlterarEstoque.setOnAction(e->windows.setScene(alterarEstoqueView));
        controllerMenuView.botaoAlterarDadosCliente.setOnAction(e->windows.setScene(alterarClienteView));
        controllerMenuView.botaoAlterarStatusVenda.setOnAction(e->{windows.setScene(alterarStatusView);});
        controllerMenuView.botaoMostrarClientes.setOnAction(e->{windows.setScene(listarClientes);
            ListaCLienteViewController c= ListaCLienteViewController.getInstance();
            c.getClientes();
        });
        controllerMenuView.botaoMostrarVendas.setOnAction(e->{windows.setScene(listarVendas);
            ListarVendaViewController c= ListarVendaViewController.getInstance();
            c.getVendas();
        });
        controllerMenuView.botaoMostrarProdutos.setOnAction(e->{ windows.setScene(listarProdutos);
            ListarProdutosViewController c= ListarProdutosViewController.getInstance();
            c.getProdutos();
        });
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

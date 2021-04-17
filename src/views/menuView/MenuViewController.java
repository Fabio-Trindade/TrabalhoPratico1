package views.menuView;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuViewController {

    private static final MenuViewController controllerMenuView = new MenuViewController();
    private MenuViewController() { }
    public static MenuViewController getInstance() {
        return controllerMenuView;
    }


    public final javafx.scene.control.Label labelMenu = new javafx.scene.control.Label("Gestão comercial");
    public final StackPane root = new StackPane();

    public VBox vBox = new VBox();

    public final javafx.scene.control.Button botaoCadastrarProduto =
            new javafx.scene.control.Button("Cadastrar produto");


    public final javafx.scene.control.Button botaoCadastrarCliente =
            new javafx.scene.control.Button("Cadastrar cliente");
    public final javafx.scene.control.Button botaoRealizarVenda =
            new javafx.scene.control.Button("RealizarVenda");
    public final javafx.scene.control.Button botaoAlterarEstoque =
            new javafx.scene.control.Button("Alterar estoque");
    public final javafx.scene.control.Button botaoAlterarDadosCliente =
            new javafx.scene.control.Button("Alterar dados de um cliente");
    public final javafx.scene.control.Button botaoAlterarStatusVenda =
            new javafx.scene.control.Button("Alterar status de uma venda");
    public final javafx.scene.control.Button botaoMostrarClientes =
            new javafx.scene.control.Button("Mostrar clientes");
    public final javafx.scene.control.Button botaoMostrarProdutos =
            new javafx.scene.control.Button("Mostrar produtos");
    public final javafx.scene.control.Button botaoMostrarVendas =
            new javafx.scene.control.Button("Mostrar vendas");



    public void configVbox(){
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10));

    }





}

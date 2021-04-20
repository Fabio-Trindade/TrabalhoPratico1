package views.menuView;

import javafx.scene.Scene;

public class MenuView {

    MenuViewController controller= MenuViewController.getInstance();

    public MenuView(){}

    public Scene getSceneMenuView(){
        Scene scene = new Scene(controller.root,1000,700);
        controller.configVbox();
        controller.vBox.getChildren().addAll(
                controller.labelMenu,
                controller.botaoCadastrarCliente,
                controller.botaoCadastrarProduto,
                controller.botaoRealizarVenda,
                controller.botaoAlterarEstoque,
                controller.botaoAlterarDadosCliente,
                controller.botaoAlterarStatusVenda,
                controller.botaoMostrarClientes,
                controller.botaoMostrarProdutos,
                controller.botaoMostrarVendas,
                controller.botaoSair

        );
        controller.root.getChildren().addAll(controller.vBox);
        return scene;
    }
}

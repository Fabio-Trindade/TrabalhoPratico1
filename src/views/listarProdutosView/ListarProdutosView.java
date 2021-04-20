package views.listarProdutosView;

import javafx.scene.Scene;
import views.listarProdutosView.ListarProdutosViewController;

public class ListarProdutosView {
    ListarProdutosViewController controller= ListarProdutosViewController.getInstance();

    public Scene getScene(){
        Scene scene = new Scene(controller.root,400,600);
        controller.initButtons();
        controller.getProdutos();
        controller.configVbox();
        controller.box.getChildren().addAll(
                controller.labelProdutos,
                controller.lebalCategoria,
                controller.textFieldCategoria,
                controller.labelErroProduto,
                controller.botaoFiltrar,
                controller.botaoVoltar
        );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

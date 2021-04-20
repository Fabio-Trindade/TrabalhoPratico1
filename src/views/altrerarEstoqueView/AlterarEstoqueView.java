package views.altrerarEstoqueView;

import javafx.scene.Scene;

public class AlterarEstoqueView {
    public AlterarEstoqueViewController controller=AlterarEstoqueViewController.getInstance();
    public AlterarEstoqueView(){}

    public Scene getScene(){
        Scene scene = new Scene(controller.root,1000,700);
        controller.initButtons();
        controller.configVbox();
        controller.box.getChildren().addAll(
                controller.labelCategoriaProduto,
                controller.textFieldProcurarProduto,
                controller.labelErroProduto,
                controller.botaoProcurarProduto,
                controller.labelNovoEstoque,
                controller.textFieldAlterarEstoque,
                controller.labelErroAlterarEstoque,
                controller.botaoAlterarEstoque,
                controller.botaoVoltar

        );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

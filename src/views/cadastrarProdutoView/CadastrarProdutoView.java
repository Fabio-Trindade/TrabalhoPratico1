package views.cadastrarProdutoView;

import javafx.scene.Scene;

public class CadastrarProdutoView {

    CadastrarProdutoViewController controller= CadastrarProdutoViewController.getInstance();


    public  CadastrarProdutoView(){}
    public Scene getSceneCadastrarProduto(){
        controller.initButtons();
        Scene scene = new Scene(controller.root,400,600);
        controller.configVbox();
        controller.vBox.getChildren().addAll(
                controller.labelDescricao,
                controller.textFieldDescricao,
                controller.labelQuantidade,
                controller.textFieldQuantidade,
                controller.labelCategoria,
                controller.textFieldCadastroCategoria,
                controller.labelPreco,
                controller.textFieldPreco,
                controller.botaoCadastrar,
                controller.botaoVoltar,
                controller.labelErro

        );
        controller.root.getChildren().addAll(
                controller.vBox
        );


        return scene;
    }
}

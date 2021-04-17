package views.altrerarEstoqueView;

import controllers.ProdutoController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;
import models.ProdutoModel;

public class AlterarEstoqueViewController {
    ProdutoModel produtoModel;

    private static final AlterarEstoqueViewController controller = new AlterarEstoqueViewController();
    private  AlterarEstoqueViewController(){}
    public static AlterarEstoqueViewController getInstance(){
        return controller;
    }

    StackPane root= new StackPane();

    VBox box= new VBox();
    public void configVbox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));

    }

    public javafx.scene.control.Label labelCategoriaProduto=
            new Label("Insira a categoria do produto que deseja alterar");
    public javafx.scene.control.Label labelErroAlterarEstoque=
            new Label("");
    public javafx.scene.control.Label labelNovoEstoque=
            new Label("Insira o novo estoque");

    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");
    public javafx.scene.control.Label labelErroProduto=
            new Label("");

    public javafx.scene.control.Button botaoAlterarEstoque=
            new javafx.scene.control.Button("Alterar estoque");
    public javafx.scene.control.Button botaoProcurarProduto=
            new javafx.scene.control.Button("Procurar");
    public javafx.scene.control.TextField textFieldProcurarProduto= new TextField();
    public javafx.scene.control.TextField textFieldAlterarEstoque= new TextField();

    public void clear(){
        textFieldAlterarEstoque.clear();
        textFieldProcurarProduto.clear();
        labelErroProduto.setText("");

    }

    public void initButtons(){
        botaoProcurarProduto.setOnAction(e->{
            String categoria=textFieldProcurarProduto.getText();
            ProdutoController pController=new ProdutoController();
            if (pController.categoriaEhValida(categoria)){
                produtoModel =pController.procurarProdutoPorCategoria(categoria);
                if(produtoModel==null){
                    labelErroProduto.setText("Produto não encontrado");
                } else{
                    labelErroProduto.setText("Descrição do produto: "+produtoModel.getDescricao());
                }

            }else{
                labelErroProduto.setText("Insira uma categoria");

            }

        });

        botaoAlterarEstoque.setOnAction(e->{
            String qtd=textFieldAlterarEstoque.getText();
            ProdutoController controller=new ProdutoController();
            if (controller.qtdEhValida(qtd)) {
                controller.alterarEstoque(Integer.parseInt(qtd),produtoModel);
                labelErroAlterarEstoque.setText("Estoque alterado");
                clear();
            }else{

                labelErroAlterarEstoque.setText("Quantidade não e válida");
            }
        });

        botaoVoltar.setOnAction(e->{
            clear();
            labelErroAlterarEstoque.setText("");
            MainController.windows.setScene(MainController.menuView);
        });
    }

}

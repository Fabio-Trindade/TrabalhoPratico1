package views.cadastrarProdutoView;

import controllers.ProdutoController;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;


public class CadastrarProdutoViewController {



    private static final CadastrarProdutoViewController cadastrarProdutoViewController =
            new CadastrarProdutoViewController();

    private CadastrarProdutoViewController(){}

    public static CadastrarProdutoViewController getInstance(){
        return cadastrarProdutoViewController;
    }


    StackPane root=new StackPane();

    public VBox vBox = new VBox();

    public javafx.scene.control.Label labelErro=
            new javafx.scene.control.Label("");
    public javafx.scene.control.Label labelDescricao=
            new javafx.scene.control.Label("Descrição do produto");
    public TextField textFieldDescricao = new TextField();
    public TextField textFieldQuantidade = new TextField();
    public TextField textFieldCadastroCategoria = new TextField();
    public javafx.scene.control.Label labelCategoria=
            new javafx.scene.control.Label("Categoria do produto");
    public javafx.scene.control.Label labelQuantidade=
            new javafx.scene.control.Label("Quantidade(Insira um número)");
    public TextField textFieldPreco = new TextField();
    public javafx.scene.control.Label labelPreco=
            new javafx.scene.control.Label("Preço do produto(Insira um número)");

    public javafx.scene.control.Button botaoCadastrar=
            new javafx.scene.control.Button("Cadastrar");
    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");

    public void configVbox(){
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10));

    }

    public void limparForms(){
        textFieldCadastroCategoria.clear();
        textFieldDescricao.clear();
        textFieldPreco.clear();
        textFieldQuantidade.clear();
    }

    public void cadastrarProduto(){
        ProdutoController produtoController= new ProdutoController();
        String descricao= textFieldDescricao.getText();
        String categoria = textFieldCadastroCategoria.getText();
        String quantidade= textFieldQuantidade.getText();
        String preco = textFieldPreco.getText();

        if(produtoController.dadosSaoValidos(descricao,categoria,quantidade,preco)){

            produtoController.cadastrarProduto(descricao,quantidade,categoria,preco);
            MainController.windows.setScene(MainController.menuView);
            limparForms();

        }else{
            labelErro.setText("Verifique se os campos estão preenchidos corretamente");
        }
    }

    public void initButtons(){
        botaoCadastrar.setOnAction(e->{
            cadastrarProduto();
       });

        botaoVoltar.setOnAction(e->{

            MainController.windows.setScene(MainController.menuView);
            limparForms();
        });

    }


}

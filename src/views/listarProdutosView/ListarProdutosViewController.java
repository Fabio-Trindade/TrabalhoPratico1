package views.listarProdutosView;

import controllers.ProdutoController;
import controllers.ProdutoController;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;

public class ListarProdutosViewController {
    static final ListarProdutosViewController controller = new ListarProdutosViewController();

    private ListarProdutosViewController(){}

    public static ListarProdutosViewController getInstance(){
        return controller;
    }

    StackPane root = new StackPane();
    VBox box = new VBox();

    public void configVbox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));
    }



    public javafx.scene.control.Label  labelErroProduto=
            new javafx.scene.control.Label("");
    public javafx.scene.control.Label  lebalCategoria=
            new javafx.scene.control.Label("Insira a categoria");
    public javafx.scene.control.TextField textFieldCategoria= new TextField();


    public javafx.scene.control.Label labelProdutos= new javafx.scene.control.Label("");


    public javafx.scene.control.Button botaoFiltrar=
            new javafx.scene.control.Button("Filtrar");
    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");


    public void clear(){

        textFieldCategoria.clear();
        labelErroProduto.setText("");
        getProdutos();
    }
    public void getProdutos(){
        String str;
        ProdutoController vendaController=new ProdutoController();
        str= vendaController.mostrarProdutos();
        labelProdutos.setText(str);
    }

    public void initButtons(){
        botaoFiltrar.setOnAction(e->{
            String categoria=textFieldCategoria.getText();
            ProdutoController controller= new ProdutoController();

            if(controller.categoriaEhValida(categoria)){
                labelProdutos.setText(controller.mostrarProdutosFiltrados(categoria));
                labelErroProduto.setText("");
            }else{
                getProdutos();
                labelErroProduto.setText("Por favor insira a categoria");
            }
        });

        botaoVoltar.setOnAction(e->{
            MainController.windows.setScene(MainController.menuView);
            clear();
        });
    }
}

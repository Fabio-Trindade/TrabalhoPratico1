package views.realizarVendaView;

import controllers.ClienteController;
import controllers.ProdutoController;
import controllers.VendaController;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;
import models.ClienteModel;
import models.ProdutoModel;
import models.entidades.Endereco;
import models.entidades.ProdutoVendido;
import models.entidades.Status;
import models.persistencia.BancoDeDadosLocal;

import java.util.ArrayList;
import java.util.List;

public class RealizarVendaViewController {
    private static  final RealizarVendaViewController realizarVendaViewController = new RealizarVendaViewController();
    private RealizarVendaViewController(){
    }
    public static RealizarVendaViewController getInstance(){
        return realizarVendaViewController;
    }

    List<ProdutoVendido> produtos=new ArrayList<>();
    ClienteModel cliente=null;
    ProdutoModel produtoModel;
    int qtdProdutosVendidos=0;

    VBox box =new VBox();

    ScrollPane root=new ScrollPane();


    public javafx.scene.control.Label  labelNomeCliente=
            new javafx.scene.control.Label("Insira o cpf do cliente (somente números)");
    public javafx.scene.control.Button botaoProcurarCliente=
            new  javafx.scene.control.Button("Adicionar cliente");
    public javafx.scene.control.TextField textFieldProcurarCliente= new TextField();
    public javafx.scene.control.Label  labelClienteFoiencontrado=
            new javafx.scene.control.Label("");
    public javafx.scene.control.Label  labelProdutoVendido=
            new javafx.scene.control.Label("Insira a categoria do produto");
    public javafx.scene.control.Button botaoAdicionarProduto= new
            javafx.scene.control.Button("Adicionar produto");
    public javafx.scene.control.Button botaoFinalizarCompra= new
            javafx.scene.control.Button("Finalizar compra");
    public javafx.scene.control.Label  labelQtdProdutosVendidos=
            new javafx.scene.control.Label(qtdProdutosVendidos+" produto(s) adicionado(s)");


    public javafx.scene.control.Label  labelErroVenda=
            new javafx.scene.control.Label("");

    public javafx.scene.control.TextField textFieldProcurarProduto= new TextField();
    public javafx.scene.control.Label  labelQuantidade= new
            javafx.scene.control.Label("Insira a quantidade que deseja comprar");
    public javafx.scene.control.TextField textFieldQuantidade= new TextField();
    public javafx.scene.control.Label  labelErroAdcionarProduto= new javafx.scene.control.Label("");
    public javafx.scene.control.Label  labelDia= new javafx.scene.control.Label("Dia(Ex:09)");
    public javafx.scene.control.TextField textFieldDia= new TextField();
    public javafx.scene.control.TextField textFieldEndereco= new TextField();
    public javafx.scene.control.Label  labelMes=
            new javafx.scene.control.Label("Mes(Ex:01)");
    public javafx.scene.control.TextField textFieldMes= new TextField();
    public javafx.scene.control.Label  labelAno=
            new javafx.scene.control.Label("Ano(Ex:2001)");
    public javafx.scene.control.Label  labelEnderecos=
            new javafx.scene.control.Label("");
    public javafx.scene.control.Label  labelEscolherEnderecos=
            new javafx.scene.control.Label("Escolha um endereço(Insira o número antes do endereço)");
    public javafx.scene.control.TextField textFieldAno= new TextField();
    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");


    public void clear(){
        textFieldEndereco.clear();
        textFieldQuantidade.clear();
        textFieldProcurarProduto.clear();
        textFieldAno.clear();
        textFieldDia.clear();
        textFieldMes.clear();
        textFieldProcurarCliente.clear();
        labelErroVenda.setText("");
        labelErroAdcionarProduto.setText("");
        labelClienteFoiencontrado.setText("");
        qtdProdutosVendidos=0;
        labelQtdProdutosVendidos.setText( qtdProdutosVendidos+" produto(s) adicionado(s)");
        cliente=null;
        produtos.clear();
        produtoModel=null;

    }



    public void initButtons(){
        botaoProcurarCliente.setOnAction(e->{
            String cpf=textFieldProcurarCliente.getText();
            ClienteController cController=new ClienteController();
            String enderecos;
            if (cController.cpfEhValido(cpf)){
                cliente=cController.procurarClientePorCPF(cpf);
                if(cliente==null){
                    labelClienteFoiencontrado.setText("Cliente não foi encontrado");
                }else{
                    enderecos=cController.retornarEnderecos(cliente);
                    labelEnderecos.setText(enderecos);
                    labelClienteFoiencontrado.setText("Cliente foi encontrado\nNome do cliente: "
                            +cliente.getNome());

                }
            }else{
                labelClienteFoiencontrado.setText("cpf inválido");
            }


        });


        botaoAdicionarProduto.setOnAction(e->{
            String qtd=textFieldQuantidade.getText();
            String categoria=textFieldProcurarProduto.getText();
            ProdutoController pController=new ProdutoController();

            produtoModel =pController.procurarProdutoPorCategoria(categoria);

            if(produtoModel==null){
                labelErroAdcionarProduto.setText("Produto não foi encontrado");
            }else{
                if(pController.dadosSaoValidos(qtd)){
                    VendaController vendaController=new VendaController();
                    if(vendaController.prodJaFoiAdc(produtos,produtoModel)){
                        labelErroAdcionarProduto.setText("Você já adicionou este produto");
                    }else{
                        if (pController.qtdEstaDisponivel(produtoModel,qtd)){
                            ProdutoVendido produtoVendido =new ProdutoVendido(produtoModel,Integer.parseInt(qtd));
                            produtos.add(produtoVendido);
                            qtdProdutosVendidos++;
                            labelQtdProdutosVendidos.setText(qtdProdutosVendidos+" produto(s) adicionado(s)");
                            labelErroAdcionarProduto.setText("");
                            textFieldProcurarProduto.clear();
                            textFieldQuantidade.clear();

                        }else{
                            labelErroAdcionarProduto.setText("Quantidade não está disponivel\n" +
                                    "Quantidade disponivel:"+produtoModel.getQtdEmEstoque());
                        }
                    }
                    }else{
                    labelErroAdcionarProduto.setText("Insira uma quantidade\n"
                           );
                }
            }

        });

        botaoRealizarVenda.setOnAction(e->{
            String dia = textFieldDia.getText();
            String mes = textFieldMes.getText();
            String ano = textFieldAno.getText();
            VendaController vendaController=new VendaController();
            ClienteController clienteController = new ClienteController();
            if(vendaController.dadosSaoValidos(dia,mes,ano)){
                if(cliente==null) {
                    labelErroVenda.setText("Adicione um cliente");
                }else if(!(clienteController.enderecoEhValido(textFieldEndereco.getText(), cliente))){
                    labelErroVenda.setText("Endereço escolhido é inválido");
                }else if(produtos.isEmpty()){
                    labelErroVenda.setText("Adicione um produto");
                }else{

                    vendaController.atualizarEstoque(produtos);
                    vendaController.addVenda(cliente,produtos,dia+"/"+mes+"/"+ano, Status.PENDENTE,
                            cliente.getEnderecos().get(Integer.parseInt(textFieldEndereco.getText())));
                    clear();
                    MainController.windows.setScene(MainController.menuView);

                }


            }else{
                labelErroVenda.setText("Data inválida");

            }


        });

        botaoVoltar.setOnAction(e->{
            clear();

            MainController.windows.setScene(MainController.menuView);

        });
    }
    public javafx.scene.control.Button botaoRealizarVenda=
            new javafx.scene.control.Button("Realizar venda");


    public void configVBox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));
    }

}

package views.cadastrarClienteView;


import controllers.ClienteController;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;
import models.ClienteModel;
import models.entidades.Endereco;

import java.util.ArrayList;
import java.util.List;


public class CadastrarClienteViewController {

    int contadorEnderecos=0;
    List<Endereco> enderecos= new ArrayList<Endereco>();
    private CadastrarClienteViewController(){}

    private  static final CadastrarClienteViewController controller = new CadastrarClienteViewController();

    public static CadastrarClienteViewController getInstance(){
        return controller;

    }

    public javafx.scene.control.Label labelCPF= new javafx.scene.control.Label("CPF(Somente números)");
    public javafx.scene.control.TextField textFieldCPF = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelNome= new javafx.scene.control.Label("Nome");
    public javafx.scene.control.TextField textFieldNome = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelEmail= new javafx.scene.control.Label("Email");
    public javafx.scene.control.TextField textFieldEmail = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelSenha= new javafx.scene.control.Label("Senha");
    public javafx.scene.control.TextField textFieldSenha = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelRua= new javafx.scene.control.Label("Rua");
    public javafx.scene.control.TextField textFieldRua = new javafx.scene.control.TextField();
    public javafx.scene.control.Label labelBairro= new javafx.scene.control.Label("Bairro");
    public javafx.scene.control.TextField textFieldBairro = new javafx.scene.control.TextField();
    public javafx.scene.control.Label labelNumero= new javafx.scene.control.Label("Numero(Número inteiro)");
    public javafx.scene.control.TextField textFieldNumero = new javafx.scene.control.TextField();
    public javafx.scene.control.Label labelQtdEnderecosCadastrados=
            new javafx.scene.control.Label("0 endereços cadastrados (é necessário pelo menos um endereço)");


    public javafx.scene.control.Button botaoCadastrar=
            new javafx.scene.control.Button("Cadastrar cliente");
    public javafx.scene.control.Button botaoCadastrarEndereco=
            new javafx.scene.control.Button("Cadastrar endereço");
    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");

    public javafx.scene.control.Label labelErro= new javafx.scene.control.Label("");

    StackPane root=new StackPane();

    public VBox box = new VBox();

    public void configVbox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));
    }

    public void clear(){
        textFieldEmail.clear();
        textFieldCPF.clear();
        textFieldNome.clear();
        textFieldSenha.clear();
        contadorEnderecos=0;
        enderecos.clear();
        labelErro.setText("");
        labelQtdEnderecosCadastrados.setText("0 endereços cadastrados (é necessário pelo menos um endereço)");
        clearEndereco();


    }
    public void clearEndereco(){
        textFieldBairro.clear();
        textFieldNumero.clear();
        textFieldRua.clear();
    }

    public void initButtons(){
        botaoCadastrar.setOnAction(e->{
            ClienteController clienteController = new ClienteController();
            String nome = textFieldNome.getText();
            String email= textFieldEmail.getText();
            String senha = textFieldSenha.getText();
            String cpf= textFieldCPF.getText();

            if(clienteController.dadosSaoValidos(nome,email,senha,cpf) && !enderecos.isEmpty()){
                clienteController.cadastrarCliente(cpf,email,senha,nome,enderecos);
                labelErro.setText("OK");
                MainController.windows.setScene(MainController.menuView);
                clear();
            }else{
                labelErro.setText("Verifique se os dados foram inseridos ou se foram inserido corretamente.");
            }

        });

        botaoVoltar.setOnAction(e->{
            clear();

            MainController.windows.setScene(MainController.menuView);

        });

        botaoCadastrarEndereco.setOnAction(e->{
            ClienteController clienteController = new ClienteController();

            String rua=textFieldRua.getText();
            String bairro= textFieldBairro.getText();
            String numero = textFieldNumero.getText();
            if(clienteController.dadosSaoValidos(rua,bairro,numero)){
                int num =Integer.parseInt(numero);
                Endereco endereco= new Endereco(rua,bairro,num);
                enderecos.add(endereco);
                contadorEnderecos++;
                labelQtdEnderecosCadastrados.setText(contadorEnderecos + " endereço(s) cadastrado(s)");
                clearEndereco();

            }else{
                labelErro.setText("Verifique se os dados foram inseridos ou se foram inserido corretamente.");
            }

        });

    }



}

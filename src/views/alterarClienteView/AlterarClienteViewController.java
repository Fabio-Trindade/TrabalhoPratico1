package views.alterarClienteView;

import controllers.ClienteController;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;
import models.ClienteModel;
import models.entidades.Endereco;
import views.cadastrarClienteView.CadastrarClienteViewController;

import java.util.ArrayList;
import java.util.List;

public class AlterarClienteViewController {
    private AlterarClienteViewController(){}
    int contador=0;

    private  static final AlterarClienteViewController controller = new AlterarClienteViewController();

    public static AlterarClienteViewController getInstance(){
        return controller;

    }
    ClienteModel cliente;

    public javafx.scene.control.Label labelCPF= new javafx.scene.control.Label("CPF(Somente números)");
    public javafx.scene.control.Label labelClienteFoiencontrado=
            new javafx.scene.control.Label("");
    public javafx.scene.control.TextField textFieldCPF = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelNome= new javafx.scene.control.Label("Nome");
    public javafx.scene.control.TextField textFieldNome = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelEmail= new javafx.scene.control.Label("Email");
    public javafx.scene.control.TextField textFieldEmail = new javafx.scene.control.TextField();

    public javafx.scene.control.Label labelSenha= new javafx.scene.control.Label("Senha");
    public javafx.scene.control.TextField textFieldSenha = new javafx.scene.control.TextField();





    public javafx.scene.control.Button botaoAlterarCliente=
            new javafx.scene.control.Button("Procurar cliente");
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
        labelErro.setText("");
        botaoAlterarCliente.setText("Procurar cliente");
        labelClienteFoiencontrado.setText("");

        contador=0;


    }


    public void initButtons(){


        botaoAlterarCliente.setOnAction(e->{
            if(contador==0){
                String cpf=textFieldCPF.getText();
                ClienteController cController=new ClienteController();

                if (cController.cpfEhValido(cpf)){
                    cliente=cController.procurarClientePorCPF(cpf);
                    if(cliente==null){
                        labelClienteFoiencontrado.setText("Cliente não foi encontrado");
                    }else{
                        textFieldEmail.setText(cliente.getEmail());
                        textFieldNome.setText(cliente.getNome());
                        textFieldSenha.setText(cliente.getSenha());
                        botaoAlterarCliente.setText("Alterar cliente");
                        labelClienteFoiencontrado.setText("");
                        contador++;

                    }
                }else{
                    labelClienteFoiencontrado.setText("cpf inválido");
                }
            }else{
                String nome= textFieldNome.getText();
                String senha=textFieldSenha.getText();
                String email=textFieldEmail.getText();
                ClienteController clienteController=new ClienteController();
                if(clienteController.dadosAlterarCadastroSaoValidos(nome,email,senha)){
                    clienteController.alterarCliente(nome,senha,email,cliente);
                    clear();
                    MainController.windows.setScene(MainController.menuView);

                }else{

                    labelErro.setText("Insira os dados");

                }

            }

        });

        botaoVoltar.setOnAction(e->{
            clear();
            MainController.windows.setScene(MainController.menuView);

        });



    }
}

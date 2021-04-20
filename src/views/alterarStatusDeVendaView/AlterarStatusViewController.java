package views.alterarStatusDeVendaView;

import controllers.ClienteController;
import controllers.VendaController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;
import models.ClienteModel;
import models.VendaModel;
import models.persistencia.BancoDeDadosLocal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AlterarStatusViewController {
    int contador;
    List<Integer> posiçaoVenda=new ArrayList<Integer>();
    private static  final AlterarStatusViewController controller=new AlterarStatusViewController();
    private AlterarStatusViewController(){}

    public static AlterarStatusViewController getInstance(){
        return controller;
    }

    StackPane root = new StackPane();
    VBox box = new VBox();

    public void configVbox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));
    }

    public javafx.scene.control.Label labelCPF= new javafx.scene.control.Label("CPF(Somente números)");
    public javafx.scene.control.Label labelClienteFoiencontrado=
            new javafx.scene.control.Label("");
    public javafx.scene.control.TextField textFieldCPF = new javafx.scene.control.TextField();
    public javafx.scene.control.Button botaoProcurarCliente=
            new javafx.scene.control.Button("Procurar cliente");
    public javafx.scene.control.Label labelVenda=
            new javafx.scene.control.Label("Insira o número da venda que deseja alterar");
    public javafx.scene.control.Label labelErro=
            new javafx.scene.control.Label("");
    public javafx.scene.control.TextField textFieldVenda = new javafx.scene.control.TextField();
    public javafx.scene.control.Label labelStatus=
            new javafx.scene.control.Label("Escolha um status:\n" +
                    "0- Pendente" +
                    "\n1-Em andamento" +
                    "\n2-Entregue");

    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");


    public void clear(){
        textFieldStatus.clear();
        contador=0;
        textFieldVenda.clear();
        textFieldCPF.clear();
        labelErro.setText("");
        labelClienteFoiencontrado.setText("");
    }
    public javafx.scene.control.TextField textFieldStatus = new javafx.scene.control.TextField();
    public void  initButtons(){

        botaoProcurarCliente.setOnAction(e->{
            String cpf=textFieldCPF.getText();
            ClienteController cController=new ClienteController();
            VendaController vendaController=new VendaController();
            ClienteModel cliente;
            if (contador==0){

                if (cController.cpfEhValido(cpf)){
                    cliente=cController.procurarClientePorCPF(cpf);
                    if(cliente==null){
                        labelClienteFoiencontrado.setText("Cliente não foi encontrado");
                    }else{
                        labelClienteFoiencontrado.setText(vendaController.retornarVendasDeUmCliente(cliente,posiçaoVenda));
                        botaoProcurarCliente.setText("Alterar status");
                        contador++;
                    }
                }else{
                    labelClienteFoiencontrado.setText("cpf inválido");
                }
            }else{
                BancoDeDadosLocal bd= BancoDeDadosLocal.getInstance();
                String pos=textFieldVenda.getText();
                String status=textFieldStatus.getText();
                if (vendaController.posEhValida(pos,bd.vendas.size())&& vendaController.statusEhValido(status)){
                   vendaController.alterarStatus(pos,status);
                    MainController.windows.setScene(MainController.menuView);
                    clear();
                }else {
                    labelErro.setText("Insira os dados corretamente");
                }
            }
            }
        );

        botaoVoltar.setOnAction(e->{
            MainController.windows.setScene(MainController.menuView);
            clear();
        });

    }

}

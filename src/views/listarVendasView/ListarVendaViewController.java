package views.listarVendasView;

import controllers.ClienteController;
import controllers.VendaController;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;

public class ListarVendaViewController {
    static final ListarVendaViewController controller = new ListarVendaViewController();

    private ListarVendaViewController(){}

    public static ListarVendaViewController getInstance(){
        return controller;
    }

    StackPane root = new StackPane();
    VBox box = new VBox();

    public void configVbox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));
    }
    public javafx.scene.control.Label  labelDia= new javafx.scene.control.Label("Dia(Ex:09)");
    public javafx.scene.control.TextField textFieldDia= new TextField();
    public javafx.scene.control.Label  labelMes=
            new javafx.scene.control.Label("Mes(Ex:01)");
    public javafx.scene.control.TextField textFieldMes= new TextField();
    public javafx.scene.control.Label  labelAno=
            new javafx.scene.control.Label("Ano(Ex:2001)");
    public javafx.scene.control.Label  labelErroVenda=
            new javafx.scene.control.Label("");
    public javafx.scene.control.TextField textFieldAno= new TextField();


    public javafx.scene.control.Label labelVendas= new javafx.scene.control.Label("");
    public javafx.scene.control.Button botaoFiltrar=
            new javafx.scene.control.Button("Filtrar");
    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");


    public void clear(){
        textFieldAno.clear();
        textFieldDia.clear();
        textFieldMes.clear();
        getVendas();
    }
    public void getVendas(){
        String str;
        VendaController vendaController=new VendaController();
        str= vendaController.mostrarVendas();
        labelVendas.setText(str);
    }

    public void initButtons(){
        botaoFiltrar.setOnAction(e->{
            String dia=textFieldDia.getText();
            String mes=textFieldMes.getText();
            String ano=textFieldAno.getText();
            VendaController controller= new VendaController();
            String filtro=dia+"/"+mes+"/"+ano;
            if(controller.dadosSaoValidos(dia,mes,ano)){
                labelVendas.setText(controller.mostrarVendasFiltradas(filtro));
            }else{
                getVendas();
                labelErroVenda.setText("Insira a data");
            }
        });

        botaoVoltar.setOnAction(e->{
            MainController.windows.setScene(MainController.menuView);
            clear();
        });
    }
}

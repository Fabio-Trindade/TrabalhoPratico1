package views.listarClientesView;

import controllers.ClienteController;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.MainController;

public class ListaCLienteViewController {
    static final ListaCLienteViewController  controller = new ListaCLienteViewController();

    private ListaCLienteViewController(){}

    public static ListaCLienteViewController getInstance(){
        return controller;
    }

    StackPane root = new StackPane();
    VBox box = new VBox();

    public void configVbox(){
        box.setSpacing(8);
        box.setPadding(new Insets(10));
    }

    public javafx.scene.control.Label labelClientes= new javafx.scene.control.Label("");
    public javafx.scene.control.Label labelFiltro= new javafx.scene.control.Label("Coloque o primeiro nome pra filtrar");
   TextField textFieldFiltro=new TextField();
    public javafx.scene.control.Button botaoFiltrar=
            new javafx.scene.control.Button("Filtrar");
    public javafx.scene.control.Button botaoVoltar=
            new javafx.scene.control.Button("Voltar");


    public void clear(){
        textFieldFiltro.clear();
        getClientes();
    }
    public void getClientes(){
        String str;
        ClienteController clienteController=new ClienteController();
        str= clienteController.mostrarClientes();
        labelClientes.setText(str);
    }


    public void initButtons(){
        botaoFiltrar.setOnAction(e->{
            ClienteController controller= new ClienteController();
            String filtro=textFieldFiltro.getText();
            labelClientes.setText(controller.mostrarClientesFiltrados(filtro));
        });

        botaoVoltar.setOnAction(e->{
            MainController.windows.setScene(MainController.menuView);
            clear();
        });
    }
}

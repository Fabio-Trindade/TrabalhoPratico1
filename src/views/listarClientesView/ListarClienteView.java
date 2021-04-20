package views.listarClientesView;

import javafx.scene.Scene;

public class ListarClienteView {

    ListaCLienteViewController controller= ListaCLienteViewController.getInstance();

    public Scene getScene(){
        Scene scene = new Scene(controller.root,400,600);
        controller.initButtons();
        controller.getClientes();
        controller.configVbox();
        controller.box.getChildren().addAll(
              controller.labelClientes,
                controller.labelFiltro,
                controller.textFieldFiltro,
                controller.botaoFiltrar,
                controller.botaoVoltar
        );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

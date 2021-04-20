package views.listarVendasView;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import views.alterarStatusDeVendaView.AlterarStatusViewController;
import views.listarVendasView.ListarVendaViewController;

public class ListarVendaView {

    ListarVendaViewController controller= ListarVendaViewController.getInstance();

    public Scene getScene(){
        Scene scene = new Scene(controller.root,1000,700);
        controller.initButtons();
        controller.getVendas();
        controller.configVbox();
        controller.box.getChildren().addAll(
                controller.labelVendas,
                controller.labelDia,
                controller.textFieldDia,
                controller.labelMes,
                controller.textFieldMes,
                controller.labelAno,
                controller.textFieldAno,
                controller.labelErroVenda,
                controller.botaoFiltrar,
                controller.botaoVoltar
        );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

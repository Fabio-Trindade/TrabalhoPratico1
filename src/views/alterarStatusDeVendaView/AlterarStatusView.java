package views.alterarStatusDeVendaView;

import javafx.scene.Scene;
import views.alterarClienteView.AlterarClienteViewController;

public class AlterarStatusView {
    AlterarStatusViewController controller= AlterarStatusViewController.getInstance();

    public Scene getScene(){
        Scene scene = new Scene(controller.root,1000,700);
        controller.initButtons();
        controller.configVbox();
        controller.box.getChildren().addAll(
                controller.labelCPF,
                controller.textFieldCPF,
                controller.labelClienteFoiencontrado,
                controller.labelVenda,
                controller.textFieldVenda,
                controller.labelStatus,
                controller.textFieldStatus,
                controller.labelErro,
                controller.botaoProcurarCliente,
                controller.botaoVoltar
                );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

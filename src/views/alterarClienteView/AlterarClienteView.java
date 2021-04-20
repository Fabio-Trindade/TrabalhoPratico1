package views.alterarClienteView;

import javafx.scene.Scene;
import views.altrerarEstoqueView.AlterarEstoqueViewController;

public class AlterarClienteView {
    AlterarClienteViewController controller= AlterarClienteViewController.getInstance();

    public Scene getScene(){
        Scene scene = new Scene(controller.root,1000,700);
        controller.initButtons();
        controller.configVbox();
        controller.box.getChildren().addAll(
                controller.labelCPF,
                controller.textFieldCPF,
                controller.labelClienteFoiencontrado,
                controller.labelNome,
                controller.textFieldNome,
                controller.labelEmail,
                controller.textFieldEmail,
                controller.labelSenha,
                controller.textFieldSenha,
                controller.labelErro,
                controller.botaoAlterarCliente,
                controller.botaoVoltar

        );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

package views.alterarClienteView;

import javafx.scene.Scene;
import views.altrerarEstoqueView.AlterarEstoqueViewController;

public class AlterarClienteView {
    AlterarClienteViewController controller= AlterarClienteViewController.getInstance();

    public Scene getScene(){
        Scene scene = new Scene(controller.root,400,600);
        controller.initButtons();
        controller.configVbox();
        controller.box.getChildren().addAll(
                controller.labelNome,
                controller.textFieldNome,
                controller.labelEmail,
                controller.textFieldEmail,
                controller.labelSenha,
                controller.textFieldSenha,
                controller.labelCPF,
                controller.textFieldCPF,
                controller.labelRua,
                controller.textFieldRua,
                controller.labelBairro,
                controller.textFieldBairro,
                controller.labelNumero,
                controller.textFieldNumero,
                controller.labelQtdEnderecosCadastrados,
                controller.botaoCadastrarEndereco,
                controller.botaoCadastrar,
                controller.botaoVoltar,
                controller.labelErro

        );
        controller.root.getChildren().addAll(controller.box);
        return scene;
    }
}

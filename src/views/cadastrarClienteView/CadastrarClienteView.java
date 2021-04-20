package views.cadastrarClienteView;

import javafx.scene.Scene;

public class CadastrarClienteView {

    CadastrarClienteViewController controller = CadastrarClienteViewController.getInstance();

    public CadastrarClienteView(){}
    public Scene getSceneCadastrarProduto(){
        controller.initButtons();
        Scene scene = new Scene(controller.root,1000,700);
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
        controller.root.getChildren().addAll(
                controller.box
        );


        return scene;
    }
}

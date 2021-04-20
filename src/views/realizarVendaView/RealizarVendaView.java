package views.realizarVendaView;

import javafx.scene.Scene;

public class RealizarVendaView {
    RealizarVendaViewController controller = RealizarVendaViewController.getInstance();

    public RealizarVendaView(){}
    public Scene getSceneRealizarVenda(){
        controller.initButtons();
        Scene scene = new Scene(controller.root,1000,700);

        controller.configVBox();
        controller.box.getChildren().addAll(
                controller.labelNomeCliente,
                controller.textFieldProcurarCliente,
                controller.labelClienteFoiencontrado,
                controller.labelEnderecos,
                controller.botaoProcurarCliente,
                controller.labelEscolherEnderecos,
                controller.textFieldEndereco,
                controller.labelProdutoVendido,
                controller.textFieldProcurarProduto,
                controller.labelQuantidade,
                controller.textFieldQuantidade,
                controller.labelErroAdcionarProduto,
                controller.labelQtdProdutosVendidos,
                controller.botaoAdicionarProduto,
                controller.labelDia,
                controller.textFieldDia,
                controller.labelMes,
                controller.textFieldMes,
                controller.labelAno,
                controller.textFieldAno,
                controller.labelErroVenda,
                controller.botaoRealizarVenda,
                controller.botaoVoltar
        );
        controller.root.setContent(
                controller.box
        );


        return scene;
    }
}

package models.entidades;

import models.ProdutoModel;

public class ProdutoVendido{
    private final ProdutoModel produto;
    private final int quantidade;

    public ProdutoVendido(ProdutoModel produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

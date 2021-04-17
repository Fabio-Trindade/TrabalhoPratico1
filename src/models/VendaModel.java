package models;

import models.entidades.Endereco;

import java.util.Date;
import java.util.List;

public class VendaModel {
    private static int idVendaGlobal=0;
    private final int idVenda;
    private final ClienteModel cliente;
    private final Endereco endereco;
    private final Date data;
    private Status status;
    List<ProdutoVendido> produtosVendidos;

    VendaModel(ClienteModel cliente,Endereco endereco,Date data,Status status,List<ProdutoVendido> produtosVendidos){
        this.cliente=cliente;
        this.produtosVendidos=produtosVendidos;
        this.status=status;
        this.endereco=endereco;
        this.data=data;
        this.idVenda=idVendaGlobal;
        idVendaGlobal++;
    }


    public int getIdVenda() {
        return idVenda;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Date getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

class ProdutoVendido{
    private final ProdutoModel produto;
    private final int quantidade;

    ProdutoVendido(ProdutoModel produto, int quantidade){
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

enum Status{
    PENDENTE("Pendente",0),
    EM_ANDAMENTO("Em andamento",1),
    ENTREGUE("Entregue",2);

    private final String status;
    private final int codigo;

    Status(String status, int codigo) {
        this.codigo=codigo;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public int getCodigo() {
        return codigo;
    }


}

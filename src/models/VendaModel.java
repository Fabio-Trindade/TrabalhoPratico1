package models;

import models.entidades.Endereco;
import models.entidades.ProdutoVendido;
import models.entidades.Status;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class VendaModel {
    private static int idVendaGlobal=0;
    private final int idVenda;
    private final ClienteModel cliente;
    private final Endereco endereco;
    private final String dataInicial;
    private String dataFinal;
    private Status status;
    List<ProdutoVendido> produtosVendidos;

    public VendaModel(ClienteModel cliente,Endereco endereco,
                      String dataInicial,Status status,List<ProdutoVendido> produtosVendidos){
        this.cliente=cliente;
        this.produtosVendidos=produtosVendidos;
        this.status=status;
        this.endereco=endereco;
        this.dataInicial=dataInicial;
        this.idVenda=idVendaGlobal;
        dataFinal=null;
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

    public String getData() {
        return dataInicial;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDatainicial() {
        return dataFinal;
    }

    public void setDatainicial(String dataFinal) {
        this.dataFinal = dataFinal;
    }
}


package controllers;

import models.ClienteModel;
import models.ProdutoModel;
import models.VendaModel;
import models.entidades.Endereco;
import models.entidades.ProdutoVendido;
import models.entidades.Status;
import models.persistencia.BancoDeDadosLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class VendaController {

    public boolean prodJaFoiAdc(List<ProdutoVendido> list, ProdutoModel produtoModel){
        for (ProdutoVendido produtoVendido : list) {
            if (produtoVendido.getProduto().equals(produtoModel)) {
                return true;
            }
        }
        return false;
    }

    public void atualizarEstoque(List<ProdutoVendido> list){
        BancoDeDadosLocal bd = BancoDeDadosLocal.getInstance();
        int i;
        ProdutoModel produtoModel;
        for (ProdutoVendido produtoVendido : list) {
            produtoModel=produtoVendido.getProduto();
            i=bd.produtos.indexOf(produtoModel);
            ProdutoModel prodM=bd.produtos.get(i);
            prodM.setQtdEmEstoque(produtoModel.getQtdEmEstoque()-produtoVendido.getQuantidade());
            bd.produtos.add(i,prodM);
        }
    }

    public void addVenda(ClienteModel clienteModel, List<ProdutoVendido> produtoVendidos,
                         String dataInicial, Status status, Endereco endereco){
        VendaModel vendaModel=new VendaModel(clienteModel,endereco,dataInicial,status,produtoVendidos);

    }
    public boolean dadosSaoValidos(String dia, String mes, String ano){
        String date=dia+"/"+mes+"/"+ano;


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (date.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;



    }
}

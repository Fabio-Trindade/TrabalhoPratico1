package controllers;

import models.ProdutoModel;
import models.persistencia.BancoDeDadosLocal;

public class ProdutoController {

    public boolean dadosSaoValidos( String descricao,String categoria,String quantidade,String preco){
        if (descricao.equals("") || categoria.equals("")){
            return false;
        }

        try{
            Integer.parseInt(quantidade);
            Double.parseDouble(preco);
        }catch (Exception e){
            return false;
        }

        return true;
    }


    public void cadastrarProduto(String descricao,String qtd,String categoria,String preco) {
        int quantidade = Integer.parseInt(qtd);
        double price = Double.parseDouble(preco);
        ProdutoModel produtoModel = new ProdutoModel(descricao,quantidade,categoria,price);
        BancoDeDadosLocal bd = BancoDeDadosLocal.getInstance();
        bd.produtos.put(produtoModel.getIdProduto(), produtoModel);
    }



}

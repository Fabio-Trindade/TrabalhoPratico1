package controllers;

import models.ClienteModel;
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

    public void alterarEstoque(int novoEstoque,ProdutoModel prod){
        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();
        int i =bd.produtos.indexOf(prod);
        bd.produtos.get(i).setQtdEmEstoque(novoEstoque);
    }

    public boolean dadosSaoValidos(String quantidade){
        try{
            Integer.parseInt(quantidade);
        }catch (Exception e){
            return false;
        }
       return (Integer.parseInt(quantidade) >0);
    }

    public boolean qtdEstaDisponivel(ProdutoModel produto,String qtd){
        int quantidade=Integer.parseInt(qtd);
        return produto.getQtdEmEstoque() >= quantidade;
    }


    public void cadastrarProduto(String descricao,String qtd,String categoria,String preco) {
        int quantidade = Integer.parseInt(qtd);
        double price = Double.parseDouble(preco);
        ProdutoModel produtoModel = new ProdutoModel(descricao,quantidade,categoria,price);
        BancoDeDadosLocal bd = BancoDeDadosLocal.getInstance();
        bd.produtos.add(produtoModel.getIdProduto(), produtoModel);
    }

    public ProdutoModel procurarProdutoPorCategoria(String categoria){
        BancoDeDadosLocal bd = BancoDeDadosLocal.getInstance();
        ProdutoModel produto;
        for (int i=0;i<bd.produtos.size();i++){
            produto=bd.produtos.get(i);
            if(produto.getCategoria().equals(categoria)){
                return produto;
            }
        }
        return null;
    }

    public boolean categoriaEhValida(String categoria){
        return !categoria.equals("");
    }

    public boolean qtdEhValida(String num){
        try{
            Integer.parseInt(num);
        }catch (Exception e){
            return false;
        }
        return Integer.parseInt(num) >= 0;
    }




}

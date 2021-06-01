package controllers;

import main.Main;
import models.ClienteModel;
import models.ProdutoModel;
import models.VendaModel;
import models.entidades.Endereco;
import models.entidades.ProdutoVendido;
import models.entidades.Status;
import models.persistencia.BancoDeDadosLocal;

import javax.lang.model.type.IntersectionType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VendaController {

    public String mostrarVendas(){
        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();
        String str="";
        VendaModel venda;
        ProdutoModel produto;
        for(int i=0;i<bd.vendas.size();i++){
            venda=bd.vendas.get(i);
            str+= "O cliente "+venda.getCliente().getNome()+" fez as seguintes compras no dia "+venda.getData()+":\n" ;
            for (int j=0;j<bd.vendas.get(i).getProdutosVendidos().size();j++){
                produto=bd.vendas.get(i).getProdutosVendidos().get(j).getProduto();

                    str +=  "Categoria: " + produto.getCategoria()+", Descrição: "+ produto.getDescricao();
                str+=", Quantidade comprada: "+bd.vendas.get(i).getProdutosVendidos().get(j).getQuantidade()+
                        ", Status:"+bd.vendas.get(i).getStatus().getStatus()+"\n";
                }

        }


        return str;
    }
    public String mostrarVendasFiltradas(String data){


        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();
        String str="";
        ProdutoModel produto;
        VendaModel venda;

        for(int i=0;i<bd.vendas.size();i++){
            venda=bd.vendas.get(i);
            if(data.equals(venda.getData())){
                str+= "O cliente "+venda.getCliente().getNome()+" fez as seguintes compras no dia "+venda.getData()+":\n" ;
                for (int j=0;j<bd.vendas.get(i).getProdutosVendidos().size();j++){
                    produto=bd.vendas.get(i).getProdutosVendidos().get(j).getProduto();
                    System.out.print(j);
                    if (j==(bd.vendas.get(i).getProdutosVendidos().size()-1)){
                        str+=produto.getCategoria()+ "\n";
                    }else{
                        str+=produto.getCategoria()+",\n";
                    }

                }
            }

        }
        return str;
    }

    public void alterarStatus(String pos,String status){
        int i=Integer.parseInt(pos);
        Status st;
        if (status.equals("0")){
            st=Status.PENDENTE;
        }else if(status.equals("1")){
            st=Status.EM_ANDAMENTO;
        }else{
            st=Status.ENTREGUE;
        }
        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();
        VendaModel venda =bd.vendas.get(i);
        venda.setStatus(st);
    }

    public boolean statusEhValido(String status){
        try {
            Integer.parseInt(status);
        }catch (Exception e) {
            return false;
        }
        int st=Integer.parseInt(status);
        return st >= 0 && st <= 2;

    }

    public boolean posEhValida(String pos,int size){
        try {
            Integer.parseInt(pos);
        }catch (Exception e) {
            return false;
        }

        return Integer.parseInt(pos) >= 0 && Integer.parseInt(pos) <= size - 1;
    }

    public String retornarVendasDeUmCliente(ClienteModel clienteModel,List<Integer> pos){
        BancoDeDadosLocal bd =BancoDeDadosLocal.getInstance();
        StringBuilder str = new StringBuilder("Cliente " + clienteModel.getNome() + " fez as seguintes compras:\n");
        ProdutoModel produto;

        if(bd.vendas.size()==0){
            return "Cliente "+ clienteModel.getNome()+" não fez compras.";
        }
        for(int i=0;i<bd.vendas.size();i++){
            if(bd.vendas.get(i).getCliente().getIdCliente()==clienteModel.getIdCliente()){
                pos.add(i);
                str.append(i).append("- ");
                for (int j=0;j<bd.vendas.get(i).getProdutosVendidos().size();j++){
                    produto=bd.vendas.get(i).getProdutosVendidos().get(j).getProduto();
                    str.append(produto.getCategoria()).append(",");
                }
                str.append(" Status:").append(bd.vendas.get(i).getStatus().getStatus()).append("\n");
            }
        }
        return str.toString();
    }

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

        List<ProdutoVendido> prodVendidos = new ArrayList<>(produtoVendidos);
        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();

        VendaModel vendaModel= new VendaModel(clienteModel,endereco,dataInicial,status,prodVendidos);

        bd.vendas.add(vendaModel);
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

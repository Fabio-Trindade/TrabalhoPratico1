package models.persistencia;

import models.ClienteModel;
import models.ProdutoModel;
import models.VendaModel;
import models.entidades.Endereco;
import models.entidades.ProdutoVendido;
import models.entidades.Status;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosLocal {

        private static final BancoDeDadosLocal DATABASE_INSTANCE = new BancoDeDadosLocal();
        public List<ClienteModel> clientes;
        public List< ProdutoModel> produtos;
        public List< VendaModel> vendas;


        private BancoDeDadosLocal() {
            clientes = new ArrayList< >();
            produtos = new ArrayList< >();
            vendas = new ArrayList< >();
            List<Endereco> enderecos=new ArrayList<>();
            Endereco endereco= new Endereco("Rua 1","Bairro 1",1);
            List<Endereco> enderecos1=new ArrayList<>();
            Endereco endereco1= new Endereco("Rua 2","Bairro 2",2);
            List<ProdutoVendido> produtoVendidos=new ArrayList<>();
            List<ProdutoVendido> produtoVendidos1=new ArrayList<>();

            clientes.add(new ClienteModel("12345678910","cliente1@gmail.com",
                    "cliente1","cliente1",enderecos));
            clientes.add(new ClienteModel("12345678911","cliente2@gmail.com",
                    "cliente2","cliente2",enderecos1));

            produtos.add(new ProdutoModel("Estojo",30,"Material escolar",10.0));
            produtos.add(new ProdutoModel("Relógio",50,"Acessório",5.0));

            vendas.add(new VendaModel(clientes.get(0),endereco,"19/04/2021", Status.PENDENTE,produtoVendidos ));
            vendas.add(new VendaModel(clientes.get(1),endereco1,"20/04/2021", Status.PENDENTE,produtoVendidos1 ));

            produtoVendidos.add(new ProdutoVendido(produtos.get(0),1));
            produtoVendidos1.add(new ProdutoVendido(produtos.get(1),2));
            enderecos.add(endereco);
            enderecos1.add(endereco1);
        }

        public static BancoDeDadosLocal getInstance() {
            return DATABASE_INSTANCE;
        }
}

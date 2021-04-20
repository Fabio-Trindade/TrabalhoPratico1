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
            Endereco endereco= new Endereco("Rua A","Getulio Vargas",35);
            List<ProdutoVendido> produtoVendidos=new ArrayList<>();

            clientes.add(new ClienteModel("10656980621","fabiotrindadefer@gmail.com",
                    "Fábio","fabio",enderecos));
            clientes.add(new ClienteModel("12345678910","raulyamaguchi@gmail.com",
                    "Raul Yamaguchi","fabio",enderecos));
            produtos.add(new ProdutoModel("Nárnia",30,"DVD",10.0));
            produtos.add(new ProdutoModel("Estojo",30,"Material escolar",5.0));
            vendas.add(new VendaModel(clientes.get(0),endereco,"12/12/2000", Status.PENDENTE,produtoVendidos ));
            vendas.add(new VendaModel(clientes.get(1),endereco,"13/12/2000", Status.PENDENTE,produtoVendidos ));


            produtoVendidos.add(new ProdutoVendido(produtos.get(0),30));
            enderecos.add(endereco);
        }

        public static BancoDeDadosLocal getInstance() {
            return DATABASE_INSTANCE;
        }
}

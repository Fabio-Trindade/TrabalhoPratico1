package models.persistencia;

import models.ClienteModel;
import models.ProdutoModel;
import models.VendaModel;
import models.entidades.Endereco;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosLocal {

        private static final BancoDeDadosLocal DATABASE_INSTANCE = new BancoDeDadosLocal();
        public List<ClienteModel> clientes;
        public List< ProdutoModel> produtos;
        public List< VendaModel> vendas;


        private BancoDeDadosLocal() {
            clientes = new ArrayList< ClienteModel>();
            produtos = new ArrayList< ProdutoModel>();
            vendas = new ArrayList< VendaModel>();
            Endereco endereco= new Endereco("Rua A","Getulio Vargas",35);
            List<Endereco> enderecos=new ArrayList<Endereco>();
            enderecos.add(endereco);
            clientes.add(new ClienteModel("10656980621","fabiotrindadefer@gmail.com",
                    "Fábio","fabio",enderecos));
            produtos.add(new ProdutoModel("Nárnia",30,"DVD",10.0));


        }

        public static BancoDeDadosLocal getInstance() {
            return DATABASE_INSTANCE;
        }
}

package models.persistencia;

import models.ClienteModel;
import models.ProdutoModel;
import models.VendaModel;

import java.util.HashMap;

public class BancoDeDadosLocal {

        private static final BancoDeDadosLocal DATABASE_INSTANCE = new BancoDeDadosLocal();
        public HashMap<Integer, ClienteModel> clientes;
        public HashMap<Integer, ProdutoModel> produtos;
        public HashMap<Integer, VendaModel> vendas;


        private BancoDeDadosLocal() {
            clientes = new HashMap<Integer, ClienteModel>();
            produtos = new HashMap<Integer, ProdutoModel>();
            vendas = new HashMap<Integer, VendaModel>();

        }

        public static BancoDeDadosLocal getInstance() {
            return DATABASE_INSTANCE;
        }
}

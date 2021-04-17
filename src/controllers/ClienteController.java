package controllers;

import models.ClienteModel;
import models.entidades.Endereco;
import models.persistencia.BancoDeDadosLocal;

import java.util.List;

public class ClienteController {

    public boolean dadosSaoValidos(String nome,String email,String senha,String cpf){
        if (nome.equals("") || email.equals("") || senha.equals("")){
            return false;
        }

        try{
            Long.parseLong(cpf);
        }catch (Exception e){
            return false;
        }
        return cpf.length() == 11;
    }
    public boolean dadosSaoValidos(String rua,String bairro,String numero){
        if (rua.equals("") || bairro.equals("") || numero.equals("")){
            return false;
        }

        try{
            Integer.parseInt(numero);
        }catch (Exception e){
            return false;
        }
        return true;
    }



    public void cadastrarCliente(String cpf, String email, String senha, String nome, List<Endereco> enderecos){
        ClienteModel cliente = new ClienteModel(cpf,email,nome,senha,enderecos);
        BancoDeDadosLocal bd= BancoDeDadosLocal.getInstance();
        bd.clientes.put(cliente.getIdCliente(),cliente);
    }
}

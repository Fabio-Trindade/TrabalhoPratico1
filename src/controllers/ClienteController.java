package controllers;

import models.ClienteModel;
import models.entidades.Endereco;
import models.persistencia.BancoDeDadosLocal;

import java.util.List;

public class ClienteController {

    public String mostrarClientes(){
        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();
        String str="";
        ClienteModel cliente;
        for(int i=0;i<bd.clientes.size();i++){
            cliente=bd.clientes.get(i);
            str+= "Nome: "+cliente.getNome()+", CPF: "+cliente.getCpf()+", Email: "+cliente.getEmail()+"\n";
        }

        return str;
    }
    public String mostrarClientesFiltrados(String nome){
        if (nome.equals("")){
            return mostrarClientes();
        }
        BancoDeDadosLocal bd=BancoDeDadosLocal.getInstance();
        String str="";
        String primemiroNome="";
        ClienteModel cliente;

        for(int i=0;i<bd.clientes.size();i++){
            cliente=bd.clientes.get(i);
            primemiroNome="";
            for(int j=0;j<cliente.getNome().length();j++){
                char[] c=cliente.getNome().toCharArray();
                if (c[j]==' ' ){
                    break;
                }
                primemiroNome+=c[j];
            }
            if (primemiroNome.equals(nome)){
                str+= "Nome: "+cliente.getNome()+", CPF: "+cliente.getCpf()+", Email: "+cliente.getEmail()+"\n";
            }

        }

        return str;
    }

    public void alterarCliente(String nome,String senha,String email,ClienteModel cliente){
        BancoDeDadosLocal bd= BancoDeDadosLocal.getInstance();
        int i = bd.clientes.indexOf(cliente);
        bd.clientes.get(i).setEmail(email);
        bd.clientes.get(i).setNome(nome);
        bd.clientes.get(i).setSenha(senha);


    }

    public boolean  dadosAlterarCadastroSaoValidos(String nome,String email,String senha){
        return !nome.equals("") && !senha.equals("") && !email.equals("");
    }

    public boolean analisarCpfEEmail(String cpf,String email){
        BancoDeDadosLocal bd = BancoDeDadosLocal.getInstance();
        ClienteModel cliente;

        for(int i=0;i<bd.clientes.size();i++){
            cliente = bd.clientes.get(i);
            if (cliente.getCpf().equals(cpf) || cliente.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

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
        bd.clientes.add(cliente);
    }

    public boolean cpfEhValido(String cpf){

        if (cpf.length() != 11) return false;

        try {
            Long.parseLong(cpf);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean enderecoEhValido(String num,ClienteModel cliente){
        try{
            Integer.parseInt(num);
        }catch (Exception e){
            return false;
        }
        int i =Integer.parseInt(num);
        return i >= 0 && i < cliente.getEnderecos().size();

    }

    public String retornarEnderecos(ClienteModel cliente){
        String str="Lista de endereços:\n";int i=0;
        for (Endereco endereco : cliente.getEnderecos()){
            str += i+"-"+endereco.getRua()+","+endereco.getBairro()+",Número "+endereco.getNumero()+"\n";
        }
        return str;
    }

    public ClienteModel procurarClientePorCPF(String cpf){
        BancoDeDadosLocal bd = BancoDeDadosLocal.getInstance();
        ClienteModel cliente;
        for (int i=0;i<bd.clientes.size();i++){
            cliente=bd.clientes.get(i);
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
    return null;
    }
}

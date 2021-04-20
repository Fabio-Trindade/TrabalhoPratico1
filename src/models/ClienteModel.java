package models;

import models.entidades.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ClienteModel {
    private static int idClienteGlobal=0;
    private final int idCliente;
    private final String cpf;
    private  String nome;
    private String email;
    private String senha;
    private List<Endereco> enderecos;

    public ClienteModel(String cpf,String email,String nome,String senha,List<Endereco> enderecos){
        this.cpf=cpf;
        this.email=email;
        this.nome=nome;
        this.senha=senha;
        this.enderecos=enderecos;
        this.idCliente=idClienteGlobal;
        idClienteGlobal++;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) { this.nome=nome; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public int getIdCliente() {
        return idCliente;
    }


}


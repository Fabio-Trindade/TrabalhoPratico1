package models.entidades;

public class Endereco {
    private String rua;
    private String bairro;
    private int numero;

    public Endereco(String rua, String bairro, int numero) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

package models;

public class ProdutoModel {
    private static int idProdGlobal=0;
    private final int idProduto;
    private String descricao;
    private int qtdEmEstoque;
    private String categoria;
    private double precoUnit;

     public ProdutoModel(String descricao, int qtdEmEstoque, String categoria, double precoUnit){
        this.categoria=categoria;
        this.descricao=descricao;
        this.qtdEmEstoque=qtdEmEstoque;
        this.idProduto= idProdGlobal;
        this.precoUnit=precoUnit;
        idProdGlobal++;

    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEmEstoque() {
        return qtdEmEstoque;
    }

    public void setQtdEmEstoque(int qtdEmEstoque) {
        this.qtdEmEstoque = qtdEmEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }
}

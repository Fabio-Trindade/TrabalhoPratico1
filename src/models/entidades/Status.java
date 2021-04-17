package models.entidades;

public enum Status {
    PENDENTE("Pendente", 0),
    EM_ANDAMENTO("Em andamento", 1),
    ENTREGUE("Entregue", 2);

    private final String status;
    private final int codigo;

    Status(String status, int codigo) {
        this.codigo = codigo;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getCodigo() {
        return codigo;
    }


}

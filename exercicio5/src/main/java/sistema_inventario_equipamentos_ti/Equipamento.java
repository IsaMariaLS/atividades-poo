package sistema_inventario_equipamentos_ti;

import java.io.Serializable;

public class Equipamento implements Serializable{

    private static final long serialVersionUID = 1L;

    private String patrimonio;
    private String nome;
    private Categoria categoria;
    private String marca;
    private String modelo;
    private StatusEquipamento status;

    //public Equipamento() {}

    public Equipamento(String patrimonio, String nome,
                       Categoria categoria,
                       String marca,
                       String modelo) {

        this.patrimonio = patrimonio;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.status = StatusEquipamento.DISPONIVEL;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public StatusEquipamento getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(StatusEquipamento status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patrimônio: " + patrimonio +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nStatus: " + status;
    }
}
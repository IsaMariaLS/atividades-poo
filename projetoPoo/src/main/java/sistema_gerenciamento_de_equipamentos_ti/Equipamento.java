package sistema_gerenciamento_de_equipamentos_ti;

import java.io.Serializable;

public class Equipamento implements Serializable{

    private static final long serialVersionUID = 1L;

    private String patrimonio;
    private String nome;
    private Categoria categoria;
    private String marca;
    private String modelo;
    private StatusEquipamento status;
    private String responsavel;
    private String setor;

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

    public String getResponsavel() {
        return responsavel;
    }

    public String getSetor() {
        return setor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(StatusEquipamento status) {
        this.status = status;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        String base = "Patrimônio: " + patrimonio +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nStatus: " + status;

        if (status == StatusEquipamento.EM_USO) {
            base += "\nResponsável: " + responsavel +
                    "\nSetor: " + setor;
        }

        return base;
    }
}
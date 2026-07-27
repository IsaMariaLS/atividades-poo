package sistema_gerenciamento_de_equipamentos_ti.controller;

import sistema_gerenciamento_de_equipamentos_ti.Categoria;
import sistema_gerenciamento_de_equipamentos_ti.Equipamento;
import sistema_gerenciamento_de_equipamentos_ti.EquipamentoJaExisteException;
import sistema_gerenciamento_de_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioAddController implements ActionListener {

    private Inventario inventario;
    private JFrame janelaInicial;

    public InventarioAddController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String patrimonio = JOptionPane.showInputDialog(janelaInicial,
                "Qual o patrimônio do equipamento?");
        if (patrimonio == null) return;

        String nome = JOptionPane.showInputDialog(janelaInicial,
                "Qual o nome do equipamento?");
        if (nome == null) return;

        String categoria = JOptionPane.showInputDialog(janelaInicial,
                "Qual a categoria do equipamento?");
        if (categoria == null) return;

        String marca = JOptionPane.showInputDialog(janelaInicial,
                "Qual a marca do equipamento?");
        if (marca == null) return;

        String modelo = JOptionPane.showInputDialog(janelaInicial,
                "Qual o modelo do equipamento?");
        if (modelo == null) return;

        try {
            Categoria categoriaEnum = Categoria.valueOf(categoria.toUpperCase());
            Equipamento equipamento = new Equipamento(patrimonio, nome, categoriaEnum, marca, modelo);
            inventario.cadastrarEquipamento(equipamento);
            JOptionPane.showMessageDialog(janelaInicial,
                    "Equipamento cadastrado");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(janelaInicial,
                    "Categoria inválida!");
        } catch (EquipamentoJaExisteException e) {
            JOptionPane.showMessageDialog(janelaInicial,
                    "Equipamento não foi cadastrado. " +
                            "Verifique se já não existia");
        }
    }
}

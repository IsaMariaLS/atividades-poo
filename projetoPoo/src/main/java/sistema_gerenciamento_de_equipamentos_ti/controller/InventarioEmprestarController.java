package sistema_gerenciamento_de_equipamentos_ti.controller;

import sistema_gerenciamento_de_equipamentos_ti.EquipamentoInexistenteException;
import sistema_gerenciamento_de_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioEmprestarController implements ActionListener {

    private Inventario inventario;
    private JFrame janelaInicial;

    public InventarioEmprestarController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String patrimonio = JOptionPane.showInputDialog(janelaInicial,
                "Qual o patrimônio do equipamento deseja emprestar?");
        String responsavel = JOptionPane.showInputDialog(janelaInicial,
                "Quem está pegando emprestado?");
        String setor = JOptionPane.showInputDialog(janelaInicial,
                "Qual o setor?");

        try {
            inventario.emprestarEquipamento(patrimonio, responsavel, setor);
            JOptionPane.showMessageDialog(janelaInicial,
                    "Emprestimo realizado!");
        } catch (EquipamentoInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaInicial,
                    "Equipamento não foi encontrado. " +
                            "Operação não realizada");
        }
    }
}
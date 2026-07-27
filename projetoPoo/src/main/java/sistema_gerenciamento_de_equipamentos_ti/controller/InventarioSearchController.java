package sistema_gerenciamento_de_equipamentos_ti.controller;

import sistema_gerenciamento_de_equipamentos_ti.Equipamento;
import sistema_gerenciamento_de_equipamentos_ti.EquipamentoInexistenteException;
import sistema_gerenciamento_de_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioSearchController implements ActionListener {

    private Inventario inventario;
    private JFrame janelaInicial;

    public InventarioSearchController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String patrimonio = JOptionPane.showInputDialog(janelaInicial,
                "Qual o patrimônio do equipamento que deseja pesquisar?");

        try {
            Equipamento equipamento = inventario.pesquisarEquipamento(patrimonio);
            JOptionPane.showMessageDialog(janelaInicial, equipamento.toString());

        } catch (EquipamentoInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaInicial,
                    "Equipamento não foi encontrado.");
        }

    }
}

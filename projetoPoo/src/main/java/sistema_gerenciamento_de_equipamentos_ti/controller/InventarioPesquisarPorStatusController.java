package sistema_gerenciamento_de_equipamentos_ti.controller;

import sistema_gerenciamento_de_equipamentos_ti.Equipamento;
import sistema_gerenciamento_de_equipamentos_ti.Inventario;
import sistema_gerenciamento_de_equipamentos_ti.StatusEquipamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class InventarioPesquisarPorStatusController implements ActionListener {
    public InventarioPesquisarPorStatusController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    private Inventario inventario;
    private JFrame janelaInicial;

    @Override
    public void actionPerformed(ActionEvent e) {
        String statusTexto = JOptionPane.showInputDialog(janelaInicial,
                "Por qual status deseja pesquisar? (ex: DISPONIVEL, EM_USO, MANUTENCAO, DESCARTADO)");
        try {
            StatusEquipamento status = StatusEquipamento.valueOf(statusTexto.toUpperCase());
            Collection<Equipamento> encontrados = inventario.pesquisarPorStatus(status);

            if (encontrados.isEmpty()) {
                JOptionPane.showMessageDialog(janelaInicial, "Nenhum equipamento encontrado.");
            } else {
                StringBuilder texto = new StringBuilder();
                for (Equipamento equipamento : encontrados) {
                    texto.append(equipamento).append("\n\n");
                }
                JOptionPane.showMessageDialog(janelaInicial, texto.toString());
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(janelaInicial, "Status inválido!");
        }
    }
}

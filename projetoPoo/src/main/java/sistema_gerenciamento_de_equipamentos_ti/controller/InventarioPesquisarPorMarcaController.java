package sistema_gerenciamento_de_equipamentos_ti.controller;


import sistema_gerenciamento_de_equipamentos_ti.Equipamento;
import sistema_gerenciamento_de_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class InventarioPesquisarPorMarcaController implements ActionListener {

    private Inventario inventario;
    private JFrame janelaInicial;

    public InventarioPesquisarPorMarcaController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String marca = JOptionPane.showInputDialog(janelaInicial,
                "Qual marca deseja pesquisar? (ex: Dell, Samsung, ...");

        Collection<Equipamento> encontrados = inventario.pesquisarPorMarca(marca);

        if (encontrados.isEmpty()) {
                JOptionPane.showMessageDialog(janelaInicial, "Nenhum equipamento encontrado.");
        } else {
            StringBuilder texto = new StringBuilder();
            for (Equipamento equipamento : encontrados) {
                texto.append(equipamento).append("\n\n");
            }
            JOptionPane.showMessageDialog(janelaInicial, texto.toString());
        }

    }
}

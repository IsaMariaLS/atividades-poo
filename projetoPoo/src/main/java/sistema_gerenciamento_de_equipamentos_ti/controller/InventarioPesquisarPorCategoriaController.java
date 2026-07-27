package sistema_gerenciamento_de_equipamentos_ti.controller;

import sistema_gerenciamento_de_equipamentos_ti.Categoria;
import sistema_gerenciamento_de_equipamentos_ti.Equipamento;
import sistema_gerenciamento_de_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class InventarioPesquisarPorCategoriaController implements ActionListener {

    private Inventario inventario;
    private JFrame janelaInicial;

    public InventarioPesquisarPorCategoriaController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String categoriaTexto = JOptionPane.showInputDialog(janelaInicial,
                "Qual categoria deseja pesquisar? (ex: NOTEBOOK, MONITOR...)");
        try {
            Categoria categoria = Categoria.valueOf(categoriaTexto.toUpperCase());
            Collection<Equipamento> encontrados = inventario.pesquisarPorCategoria(categoria);

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
            JOptionPane.showMessageDialog(janelaInicial, "Categoria inválida!");
        }
    }
}
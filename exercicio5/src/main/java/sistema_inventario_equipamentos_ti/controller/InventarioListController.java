package sistema_inventario_equipamentos_ti.controller;

import sistema_inventario_equipamentos_ti.Equipamento;
import sistema_inventario_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class InventarioListController implements ActionListener {

    private Inventario inventario;
    private JFrame janelaInicial;

    public InventarioListController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Collection<Equipamento> equipamentos = inventario.listarEquipamentos();

        if (equipamentos.isEmpty()) {
            JOptionPane.showMessageDialog(janelaInicial, "A lista está vazia.");
        }
        else {
            StringBuilder texto = new StringBuilder();
            for (Equipamento equipamento : equipamentos) {
                texto.append(equipamento).append("\n\n");

            }
            JOptionPane.showMessageDialog(janelaInicial, texto.toString());
        }


    }
}

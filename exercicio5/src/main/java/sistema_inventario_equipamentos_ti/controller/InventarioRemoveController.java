package sistema_inventario_equipamentos_ti.controller;

import sistema_inventario_equipamentos_ti.EquipamentoInexistenteException;
import sistema_inventario_equipamentos_ti.Inventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioRemoveController implements ActionListener {

    private Inventario inventario;
    private JFrame  janelaInicial;

    public InventarioRemoveController(Inventario inventario, JFrame janelaInicial) {
        this.inventario = inventario;
        this.janelaInicial = janelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String patrimonio = JOptionPane.showInputDialog(janelaInicial,
                "Qual o patrimônio do equipamento que deseja remover?");

        try {
            inventario.removerEquipamento(patrimonio);
            JOptionPane.showMessageDialog(janelaInicial,
                    "Equipamento removido com sucesso");
        } catch (EquipamentoInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaInicial,
                    "Equipamento não foi encontrado. "+
                            "Operação não realizada");
        }

    }
}

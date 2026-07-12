package sistema_inventario_equipamentos_ti.gui;

import sistema_inventario_equipamentos_ti.Inventario;
import sistema_inventario_equipamentos_ti.SistemaInventario;
import sistema_inventario_equipamentos_ti.controller.InventarioSearchController;
import sistema_inventario_equipamentos_ti.controller.InventarioAddController;
import sistema_inventario_equipamentos_ti.controller.InventarioListController;
import sistema_inventario_equipamentos_ti.controller.InventarioRemoveController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TelaPrincipal extends JFrame {

    private Inventario inventario = new SistemaInventario();
    JMenuBar barraDeMenu = new JMenuBar();
    

    public TelaPrincipal() {
        setTitle("Inventário de Equipamentos TI");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuSalvar = new JMenuItem("Salvar Dados");
        menuArquivo.add(menuSalvar);

        JMenu menuEquipamentos = new JMenu("Equipamentos");
        JMenuItem menuCadastrarEquipamento =
                new JMenuItem("Cadastrar Equipamento");
        JMenuItem menuPesquisarEquipamento =
                new JMenuItem("Pesquisar Equipamento");
        JMenuItem menuRemoverEquipamento =
                new JMenuItem("Remover Equipamento");
        JMenuItem menuListarEquipamento =
                new JMenuItem("Listar Equipamentos");


        menuEquipamentos.add(menuCadastrarEquipamento);
        menuEquipamentos.add(menuPesquisarEquipamento);
        menuEquipamentos.add(menuRemoverEquipamento);
        menuEquipamentos.add(menuListarEquipamento);

        menuCadastrarEquipamento.addActionListener(
                new InventarioAddController(inventario, this));

        menuPesquisarEquipamento.addActionListener(
                new InventarioSearchController(inventario,this));

        menuRemoverEquipamento.addActionListener(
                new InventarioRemoveController(inventario, this));

        menuListarEquipamento.addActionListener(
                new InventarioListController(inventario,this));

        menuSalvar.addActionListener(
                (ae) -> {
                    try {
                        inventario.salvarDados();
                        JOptionPane.showMessageDialog(this,
                                "Dados salvos com sucesso!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this,
                                "Erro ao salvar dados: " + e.getMessage());
                    }
                });

        barraDeMenu.add(menuArquivo);
        barraDeMenu.add(menuEquipamentos);
        setJMenuBar(barraDeMenu);
    }

}
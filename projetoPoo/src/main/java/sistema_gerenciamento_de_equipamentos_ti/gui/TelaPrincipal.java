package sistema_gerenciamento_de_equipamentos_ti.gui;

import sistema_gerenciamento_de_equipamentos_ti.Inventario;
import sistema_gerenciamento_de_equipamentos_ti.SistemaInventario;
import sistema_gerenciamento_de_equipamentos_ti.controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class TelaPrincipal extends JFrame {

    private Inventario inventario;
    JMenuBar barraDeMenu = new JMenuBar();


    JMenuItem menuCadastrarEquipamento;
    JMenuItem menuPesquisarEquipamento;
    JMenuItem menuEmprestarEquipamento;
    JMenuItem menuListarEquipamento;

    public TelaPrincipal() {
        setTitle("Sistema de Gerenciamento de Equipamentos TI");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sairDoSistema();
            }
        });

        try {
            inventario = new SistemaInventario();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados salvos, iniciando vazio: " + e.getMessage());
            inventario = new SistemaInventario(true);
        }

        // ---------- Menu Arquivo ----------
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuSalvar = new JMenuItem("Salvar Dados");
        JMenuItem menuSair = new JMenuItem("Sair");
        menuArquivo.add(menuSalvar);
        menuArquivo.add(menuSair);

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

        menuSair.addActionListener(e -> sairDoSistema());

        // ---------- Menu Equipamentos ----------
        JMenu menuEquipamentos = new JMenu("Equipamentos");
        menuCadastrarEquipamento = new JMenuItem("Cadastrar Equipamento");
        JMenuItem menuRemoverEquipamento = new JMenuItem("Remover Equipamento");
        menuListarEquipamento = new JMenuItem("Listar Equipamentos");
        menuEmprestarEquipamento = new JMenuItem("Emprestar Equipamento");
        JMenuItem menuDevolverEquipamento = new JMenuItem("Devolver Equipamento");

        menuEquipamentos.add(menuCadastrarEquipamento);
        menuEquipamentos.add(menuRemoverEquipamento);
        menuEquipamentos.add(menuListarEquipamento);
        menuEquipamentos.add(menuEmprestarEquipamento);
        menuEquipamentos.add(menuDevolverEquipamento);

        menuCadastrarEquipamento.addActionListener(
                new InventarioAddController(inventario, this));
        menuRemoverEquipamento.addActionListener(
                new InventarioRemoveController(inventario, this));
        menuListarEquipamento.addActionListener(
                new InventarioListController(inventario, this));
        menuEmprestarEquipamento.addActionListener(
                new InventarioEmprestarController(inventario, this));
        menuDevolverEquipamento.addActionListener(
                new InventarioDevolverController(inventario, this));

        // ---------- Submenu Pesquisar ----------
        JMenu menuPesquisar = new JMenu("Pesquisar");
        menuPesquisarEquipamento = new JMenuItem("Por Patrimônio");
        JMenuItem menuPesquisarCategoria = new JMenuItem("Por Categoria");
        JMenuItem menuPesquisarMarca = new JMenuItem("Por Marca");
        JMenuItem menuPesquisarStatus = new JMenuItem("Por Status");

        menuPesquisar.add(menuPesquisarEquipamento);
        menuPesquisar.add(menuPesquisarCategoria);
        menuPesquisar.add(menuPesquisarMarca);
        menuPesquisar.add(menuPesquisarStatus);

        menuPesquisarEquipamento.addActionListener(
                new InventarioSearchController(inventario, this));
        menuPesquisarCategoria.addActionListener(
                new InventarioPesquisarPorCategoriaController(inventario, this));
        menuPesquisarMarca.addActionListener(
                new InventarioPesquisarPorMarcaController(inventario, this));
        menuPesquisarStatus.addActionListener(
                new InventarioPesquisarPorStatusController(inventario, this));

        barraDeMenu.add(menuArquivo);
        barraDeMenu.add(menuEquipamentos);
        barraDeMenu.add(menuPesquisar);
        setJMenuBar(barraDeMenu);
    }

    private void sairDoSistema() {
        try {
            inventario.salvarDados();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar dados antes de sair: " + e.getMessage());
        }
        System.exit(0);
    }
}
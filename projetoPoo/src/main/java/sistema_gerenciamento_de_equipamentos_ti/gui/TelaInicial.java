package sistema_gerenciamento_de_equipamentos_ti.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaInicial extends JFrame {

    public TelaInicial() {
        setTitle("Sistema de Gerenciamento de Equipamentos de TI");
        setSize(550, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(20, 35, 100));
        setLayout(new BorderLayout());

        // ---------- Painel do topo (só imagem) ----------
        JPanel painelTopo = new JPanel();
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS));
        painelTopo.setBackground(new Color(20, 35, 100));
        painelTopo.setBorder(new EmptyBorder(25, 20, 20, 20));

        JLabel labelImagem = criarLabelImagem("/imgs/logo.png", 520, 320);
        labelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelTopo.add(labelImagem);

        // ---------- Painel dos botões ----------
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBackground(new Color(20, 35, 100));
        painelBotoes.setBorder(new EmptyBorder(10, 40, 30, 40));

        JButton botaoCadastrar = criarBotao("Cadastrar Equipamento");
        JButton botaoPesquisar = criarBotao("Pesquisar Equipamento");
        JButton botaoEmprestar = criarBotao("Emprestar Equipamento");
        JButton botaoListar = criarBotao("Listar Equipamentos");

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 12)));
        painelBotoes.add(botaoPesquisar);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 12)));
        painelBotoes.add(botaoEmprestar);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 12)));
        painelBotoes.add(botaoListar);

        botaoCadastrar.addActionListener(e -> executarAcaoRapida(t -> t.menuCadastrarEquipamento));
        botaoPesquisar.addActionListener(e -> executarAcaoRapida(t -> t.menuPesquisarEquipamento));
        botaoEmprestar.addActionListener(e -> executarAcaoRapida(t -> t.menuEmprestarEquipamento));
        botaoListar.addActionListener(e -> executarAcaoRapida(t -> t.menuListarEquipamento));

        add(painelTopo, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private JLabel criarLabelImagem(String caminho, int largura, int altura) {
        java.net.URL url = getClass().getResource(caminho);

        if (url == null) {
            JLabel labelFallback = new JLabel("(imagem não encontrada: " + caminho + ")");
            labelFallback.setAlignmentX(Component.CENTER_ALIGNMENT);
            labelFallback.setForeground(Color.GRAY);
            return labelFallback;
        }

        ImageIcon icone = new ImageIcon(url);
        Image imagemRedimensionada = icone.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(imagemRedimensionada));
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setFont(new Font("SansSerif", Font.PLAIN, 14));
        botao.setFocusPainted(false);
        botao.setMaximumSize(new Dimension(300, 40));
        botao.setBackground(new Color(70, 110, 180));
        botao.setForeground(Color.WHITE);
        return botao;
    }

    private void executarAcaoRapida(java.util.function.Function<TelaPrincipal, JMenuItem> extrairItem) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        extrairItem.apply(telaPrincipal).doClick();
        telaPrincipal.dispose();
    }
}
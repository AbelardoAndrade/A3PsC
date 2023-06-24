import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaMenu extends JFrame implements ActionListener {

    private final JButton botaoAdicionarCliente;
    private final JButton botaoAdicionarVenda;
    private final JButton botaoVoltar;

    public TelaMenu() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Painel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());

        // Configuração do GridBagConstraints para o painel principal
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainGbc.weightx = 1.0;
        mainGbc.weighty = 1.0;
        mainGbc.fill = GridBagConstraints.BOTH;
        mainGbc.insets = new Insets(15, 50, 10, 50);

        // Cria a borda verde escura
        Color borderColor = new Color(0, 128, 0);
        int borderWidth = 1;
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(BorderFactory.createLineBorder(borderColor, borderWidth));

        // Configuração do GridBagConstraints para o conteúdo central
        GridBagConstraints contentGbc = new GridBagConstraints();
        contentGbc.gridx = 0;
        contentGbc.gridy = 0;
        contentGbc.weightx = 1.0;
        contentGbc.weighty = 1.0;
        contentGbc.fill = GridBagConstraints.BOTH;
        contentGbc.insets = new Insets(5, 50, 10, 50);

        // Adiciona o painel do logo
        GridBagConstraints logoGbc = new GridBagConstraints();
        logoGbc.gridx = 0;
        logoGbc.gridy = 0;
        logoGbc.gridwidth = 2;
        logoGbc.anchor = GridBagConstraints.CENTER;

        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("logo.png"));
        JLabel logoLabel = new JLabel(logoIcon);
        logoPanel.add(logoLabel);

        contentPanel.add(logoPanel, logoGbc);

        // Configuração do GridBagConstraints para os botões
        GridBagConstraints buttonGbc = new GridBagConstraints();
        buttonGbc.gridx = 0;
        buttonGbc.gridy = 1;
        buttonGbc.gridwidth = 2;
        buttonGbc.anchor = GridBagConstraints.CENTER;
        buttonGbc.insets = new Insets(10, 0, 0, 0);

        // Botões + eventos
        botaoAdicionarCliente = new JButton("Clientes");
        botaoAdicionarCliente.addActionListener(this);

        botaoAdicionarVenda = new JButton("Vendas");
        botaoAdicionarVenda.addActionListener(this);

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(this);

        contentPanel.add(botaoAdicionarCliente, buttonGbc);

        buttonGbc.gridy = 2;
        contentPanel.add(botaoAdicionarVenda, buttonGbc);

        buttonGbc.gridy = 3;
        contentPanel.add(botaoVoltar, buttonGbc);

        setButtonSize(botaoAdicionarCliente, 200);
        setButtonSize(botaoAdicionarVenda, 200);
        setButtonSize(botaoVoltar, 200);

        mainPanel.add(contentPanel, contentGbc);
        add(mainPanel, mainGbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAdicionarCliente) {
            abrirTelaAdicionarCliente();
        } else if (e.getSource() == botaoAdicionarVenda) {
            abrirTelaVenda();
        } else if (e.getSource() == botaoVoltar) {
            voltarTelaLogin();
        }
    }

    private void abrirTelaAdicionarCliente() {
        setVisible(false);
        dispose();
        new TelaAdicionarCliente();
    }

    private void abrirTelaVenda() {
        JOptionPane.showMessageDialog(this, "Você será redirecionado para Vendas");
        setVisible(false);
        dispose();
        new TelaVenda();
    }

    private void voltarTelaLogin() {
        setVisible(false);
        dispose();
        new A3PsC.TelaLogin();
    }

    private void setPadding(int padding) {
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
    }

    private void setButtonSize(JButton button, int size) {
        Dimension dimension = new Dimension(size, button.getPreferredSize().height);
        button.setPreferredSize(dimension);
    }

    public static void main(String[] args) {
        new TelaMenu();
    }
}

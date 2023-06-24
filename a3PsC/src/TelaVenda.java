import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TelaVenda extends JFrame implements ActionListener {

    private final JButton botaoPesquisar;
    private final JButton botaoMenu;
    private final JButton botaoSair;
    private final JTextField clienteField;
    private final JTextField pedidoField;
    private final JTextField rastreioField;
    private final JTextField nfField;
    private final JTextField valorField;
    private final JLabel labelSubtitulo;

    public TelaVenda() {
        setTitle("Venda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setPadding(35);

        labelSubtitulo = new JLabel("Pesquisa de Venda:");
        labelSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 10, 20, 10);

        // Campos da TelaVenda
        clienteField = addField("ID Cliente:", constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        pedidoField = addField("Codigo de Venda:", constraints);
        constraints.gridx = 2;
        rastreioField = addField("Rastreio:", constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        nfField = addField("Validade:", constraints);
        constraints.gridx = 2;
        valorField = addField("Valor:", constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.addActionListener(this);
        add(botaoPesquisar, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        botaoMenu = new JButton("Menu");
        botaoMenu.addActionListener(this);
        add(botaoMenu, constraints);

        constraints.gridx = 1;
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener(this);
        add(botaoSair, constraints);

        setButtonSize(botaoPesquisar, 150);
        setButtonSize(botaoMenu, 75);
        setButtonSize(botaoSair, 75);

        setVisible(true);
    }

    private JTextField addField(String fieldName, GridBagConstraints constraints) {
        constraints.gridx = 0;
        JLabel label = new JLabel(fieldName);
        add(label, constraints);

        constraints.gridx = 1;
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 25));
        add(textField, constraints);

        constraints.gridy++;

        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoMenu) {
            voltarTelaMenu();
        } else if (e.getSource() == botaoSair) {
              setVisible(false);
            dispose();
            new A3PsC.TelaLogin();
        } else if (e.getSource() == botaoPesquisar) {
            realizarPesquisa();
        }
    }

    private void voltarTelaMenu() {
        setVisible(false);
        dispose();
        new TelaMenu();
    }

    private void voltarTelaLogin() {
        setVisible(false);
        dispose();
        new TelaLogin();
    }

    private void realizarPesquisa() {
        String cliente = clienteField.getText();
        String pedido = pedidoField.getText();
        String rastreio = rastreioField.getText();
        String nf = nfField.getText();
        String valor = valorField.getText();

        String mensagem = "ID Cliente: " + cliente + "\n"
                + "Código de venda: " + pedido + "\n"
                + "Rastreio: " + rastreio + "\n"
                + "Validade: " + nf + "\n"
                + "Valor: " + valor;

        JOptionPane.showMessageDialog(this, mensagem);
    }

    private void setPadding(int padding) {
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
    }

    private void setButtonSize(JButton button, int size) {
        Dimension dimension = new Dimension(size, button.getPreferredSize().height);
        button.setPreferredSize(dimension);
    }
}



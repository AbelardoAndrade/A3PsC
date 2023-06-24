import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAdicionarCliente extends JFrame implements ActionListener {

    private final JLabel labelNome;
    private final JLabel labelCNPJ;
    private final JLabel labelTelefone;
    private final JLabel labelEndereco;
    private final JLabel labelEstado;
    private final JTextField campoNome;
    private final JTextField campoCNPJ;
    private final JTextField campoTelefone;
    private final JTextField campoEndereco;
    private final JComboBox<String> comboEstado;
    private final JButton botaoCriar;
    private final JButton botaoVoltar;
    private final JLabel labelSubtitulo;
    private final JButton botaoPesquisar;
    private final JTextField campoPesquisa;

    public TelaAdicionarCliente() {
        setTitle("Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setPadding(35);

        labelSubtitulo = new JLabel("Novo Cliente:");
        labelSubtitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelSubtitulo, createGridBagConstraints(0, 0, 2, 1, GridBagConstraints.CENTER));

        labelNome = new JLabel("Nome:");
        labelCNPJ = new JLabel("CNPJ:");
        labelTelefone = new JLabel("Telefone:");
        labelEndereco = new JLabel("Endereço:");
        labelEstado = new JLabel("Estado:");

        campoNome = new JTextField();
        campoCNPJ = new JTextField();
        campoTelefone = new JTextField();
        campoEndereco = new JTextField();

        campoNome.setColumns(25);
        campoCNPJ.setColumns(25);
        campoTelefone.setColumns(11);
        campoEndereco.setColumns(35);

        comboEstado = new JComboBox<>(new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});

        botaoCriar = new JButton("Criar");
        botaoVoltar = new JButton("Voltar");
        botaoPesquisar = new JButton("Pesquisar");

        botaoCriar.addActionListener(this);
        botaoVoltar.addActionListener(this);
        botaoPesquisar.addActionListener(this);

        GridBagConstraints gbc = createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.EAST);
        add(labelNome, gbc);

        gbc = createGridBagConstraints(1, 1, 1, 1, GridBagConstraints.WEST);
        add(campoNome, gbc);

        gbc = createGridBagConstraints(0, 2, 1, 1, GridBagConstraints.EAST);
        add(labelCNPJ, gbc);

        gbc = createGridBagConstraints(1, 2, 1, 1, GridBagConstraints.WEST);
        add(campoCNPJ, gbc);

        gbc = createGridBagConstraints(0, 3, 1, 1, GridBagConstraints.EAST);
        add(labelTelefone, gbc);

        gbc = createGridBagConstraints(1, 3, 1, 1, GridBagConstraints.WEST);
        add(campoTelefone, gbc);

        gbc = createGridBagConstraints(0, 4, 1, 1, GridBagConstraints.EAST);
        add(labelEndereco, gbc);

        gbc = createGridBagConstraints(1, 4, 1, 1, GridBagConstraints.WEST);
        add(campoEndereco, gbc);

        gbc = createGridBagConstraints(0, 5, 1, 1, GridBagConstraints.EAST);
        add(labelEstado, gbc);

        gbc = createGridBagConstraints(1, 5, 1, 1, GridBagConstraints.WEST);
        add(comboEstado, gbc);

        gbc = createGridBagConstraints(0, 6, 2, 1, GridBagConstraints.CENTER);
        gbc.insets = new Insets(10, 0, 0, 0);
        add(botaoCriar, gbc);

        gbc = createGridBagConstraints(0, 7, 2, 1, GridBagConstraints.CENTER);
        gbc.insets = new Insets(20, 0, 0, 0);
        add(new JLabel(), gbc); // Espaçamento entre as seções

        gbc = createGridBagConstraints(0, 8, 2, 1, GridBagConstraints.CENTER);
        gbc.insets = new Insets(20, 0, -25, 0);
        add(new JLabel(""), gbc); // Título da seção de pesquisa

        gbc = createGridBagConstraints(0, 9, 2, 1, GridBagConstraints.CENTER);
        gbc.insets = new Insets(5, 0, 20, 0);
        campoPesquisa = new JTextField();
        campoPesquisa.setPreferredSize(new Dimension(campoNome.getPreferredSize().width, campoPesquisa.getPreferredSize().height));
        add(campoPesquisa, gbc);

        gbc = createGridBagConstraints(0, 10, 2, 1, GridBagConstraints.CENTER);
        gbc.insets = new Insets(20, 0, 0, 0);
        add(botaoPesquisar, gbc);
        
        gbc = createGridBagConstraints(0, 11, 2, 1, GridBagConstraints.CENTER);
        gbc.insets = new Insets(20, 0, 0, 0);
        add(botaoVoltar, gbc);

        setVisible(true);
    }

    // Método utilitário para criar um objeto GridBagConstraints com os parâmetros desejados
    private GridBagConstraints createGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.anchor = anchor;
        gbc.insets = new Insets(5, 5, 5, 5);
        return gbc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoCriar) {
            // Lógica para criar o cliente
            String nome = campoNome.getText();
            String cnpj = campoCNPJ.getText();
            String telefone = campoTelefone.getText();
            String endereco = campoEndereco.getText();
            String estado = comboEstado.getSelectedItem().toString();

            JOptionPane.showMessageDialog(this, "Cliente criado:\nNome: " + nome + "\nCNPJ: " + cnpj + "\nTelefone: " + telefone + "\nEndereço: " + endereco + "\nEstado: " + estado);
        } else if (e.getSource() == botaoVoltar) {
            voltarTelaMenu();
        } else if (e.getSource() == botaoPesquisar) {
            // Lógica para pesquisa do cliente
            String pesquisa = campoPesquisa.getText();
            // Realize a pesquisa com o termo fornecido
campoNome.setText("");
            campoCNPJ.setText("");
            campoTelefone.setText("");
            campoEndereco.setText("");
            comboEstado.setSelectedIndex(0);
            String nome = campoNome.getText();
            String cnpj = campoCNPJ.getText();
            String telefone = campoTelefone.getText();
            String endereco = campoEndereco.getText();
            String estado = comboEstado.getSelectedItem().toString();
            // Exemplo de diálogo mostrando o resultado da pesquisa
             JOptionPane.showMessageDialog(this, "Resultado da Pesquisa:\nNome: " + nome + "\nCNPJ: " + cnpj + "\nTelefone: " + telefone + "\nEndereço: " + endereco + "\nEstado: " + estado);
        }
    }

    private void voltarTelaMenu() {
        setVisible(false);
        dispose();
        new TelaMenu();
    }

    private void setPadding(int padding) {
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
    }

    private void setButtonSize(JButton button, int size) {
        Dimension dimension = new Dimension(size, button.getPreferredSize().height);
        button.setPreferredSize(dimension);
    }

    private void setFieldHeight(JTextField field, int height) {
        field.setPreferredSize(new Dimension(field.getPreferredSize().width, height));
    }
}

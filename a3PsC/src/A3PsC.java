import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;


public class A3PsC {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin());
    
    }
    public static class TelaLogin extends JFrame implements ActionListener {
        private final JLabel labelUsuario;
        private final JLabel labelSenha;
        private final JTextField campoUsuario;
        private final JPasswordField campoSenha;
        private final JButton botaoLogin;
        private final JButton botaoCriarUsuario;

             public TelaLogin() {
        setTitle("A3 Laticínios - Login");
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

        // Adiciona os rótulos
        contentGbc.gridy = 1;
        labelUsuario = new JLabel("Usuário:");
        contentPanel.add(labelUsuario, contentGbc);
        contentGbc.gridy = 2;
        labelSenha = new JLabel("Senha:");
        contentPanel.add(labelSenha, contentGbc);

        // Adiciona os campos de texto
        contentGbc.gridy = 1;
        contentGbc.gridx = 1;
        campoUsuario = new JTextField();
        contentPanel.add(campoUsuario, contentGbc);
        contentGbc.gridy = 2;
        campoSenha = new JPasswordField();
        contentPanel.add(campoSenha, contentGbc);

         // Adiciona os botões
            contentGbc.gridy = 3;
            botaoLogin = new JButton("Login");
            botaoLogin.addActionListener(this);
            contentPanel.add(botaoLogin, contentGbc);

            contentGbc.gridy = 4;
            botaoCriarUsuario = new JButton("Criar Novo Usuário");
            botaoCriarUsuario.addActionListener(this);
            contentPanel.add(botaoCriarUsuario, contentGbc);

        // Adiciona o contentPanel ao mainPanel
        mainPanel.add(contentPanel, mainGbc);

        // Adiciona o mainPanel ao JFrame
        add(mainPanel);

        setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botaoLogin) {
                realizarLogin();
            } else if (e.getSource() == botaoCriarUsuario) {
                abrirTelaCriarUsuario();
            }
        }

        private void realizarLogin() {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            // Verificar se o usuário e a senha estão corretos
            if (usuario.equals("admin") && senha.equals("12345")) {
                abrirTelaMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos");
            }
        }

        private void abrirTelaMenu() {
            setVisible(false);
            dispose(); // Fecha a tela de login
            TelaMenu telaMenu = new TelaMenu();
        }

        private void abrirTelaCriarUsuario() {
            setVisible(false);
            dispose();
            new TelaCriarUsuario();
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

        private void setFieldMaxLength(JTextField field, int maxLength) {
            ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                    if (fb.getDocument().getLength() + text.length() <= maxLength) {
                        super.insertString(fb, offset, text, attr);
                    }
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (fb.getDocument().getLength() - length + text.length() <= maxLength) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            });
        }
    }

    static class TelaAdicionarCliente {

        public TelaAdicionarCliente() {
        }
    }
  }
    
    





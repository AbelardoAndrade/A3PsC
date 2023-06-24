import java.awt.Dimension;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TelaCriarUsuario extends JFrame implements ActionListener {

private final JLabel labelNome;
private final JLabel labelIdFuncionario;
private final JLabel labelSenha;
private final JTextField campoNome;
private final JTextField campoIdFuncionario;
private final JPasswordField campoSenha;
private final JButton botaoEnviar;
private final JButton botaoVoltar;
private final JLabel labelSubtitulo;

public TelaCriarUsuario() {
    setTitle("Novo Usuário");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700, 700);
    setLocationRelativeTo(null);
    setLayout(new GridBagLayout());
    setPadding(35);

    labelSubtitulo = new JLabel("Preencha as informações abaixo:");
    labelSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(10, 0, 20, 0);
    add(labelSubtitulo, gbc);

    labelNome = new JLabel("E-mail:");
    labelIdFuncionario = new JLabel("ID Funcionário:");
    labelSenha = new JLabel("Senha:");
    campoNome = new JTextField();
    campoIdFuncionario = new JTextField();
    campoSenha = new JPasswordField();
    botaoEnviar = new JButton("Enviar");
    botaoVoltar = new JButton("Voltar");

    botaoEnviar.addActionListener(this);
    botaoVoltar.addActionListener(this);

    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.insets = new Insets(0, 0, 10, 10);
    add(labelNome, gbc);

    gbc.gridy = 2;
    add(labelIdFuncionario, gbc);

    gbc.gridy = 3;
    add(labelSenha, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(0, 0, 10, 0);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(campoNome, gbc);

    gbc.gridy = 2;
    add(campoIdFuncionario, gbc);

    gbc.gridy = 3;
    add(campoSenha, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(20, 0, 10, 0);
    add(botaoEnviar, gbc);

    gbc.gridy = 5;
    gbc.insets = new Insets(0, 0, 0, 0);
    add(botaoVoltar, gbc);

    setButtonSize(botaoEnviar, 25);
    setButtonSize(botaoVoltar, 25);
    setFieldHeight(campoNome, 20);
    setFieldHeight(campoIdFuncionario, 20);
    setFieldMaxLength(campoNome, 30);
    setFieldNumericOnly(campoIdFuncionario);

    
    
    setVisible(true);
}

private void setPadding(int padding) {
    ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
}

private void setButtonSize(JButton button, int height) {
    Dimension dimension = button.getPreferredSize();
    dimension.height = height;
    button.setPreferredSize(dimension);
}

private void setFieldHeight(JTextField field, int height) {
    Dimension dimension = field.getPreferredSize();
    dimension.height = height;
    field.setPreferredSize(dimension);
}

private void setFieldMaxLength(JTextField field, int maxLength) {
    ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (fb.getDocument().getLength() + string.length() <= maxLength) {
                super.insertString(fb, offset, string, attr);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (fb.getDocument().getLength() + text.length() - length <= maxLength) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    });
}

private void setFieldNumericOnly(JTextField field) {
    ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    });
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(TelaCriarUsuario::new);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == botaoEnviar) {
        // Código para tratar o evento do botão "Enviar"
        JOptionPane.showMessageDialog(this, "Usuário Criado com Sucesso!");
    } else if (e.getSource() == botaoVoltar) {
        setVisible(false);
        dispose();
        new A3PsC.TelaLogin();
    }
}
}






            
            
        
    

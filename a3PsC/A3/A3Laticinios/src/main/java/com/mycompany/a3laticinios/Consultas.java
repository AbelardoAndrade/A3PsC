package com.mycompany.a3laticinios;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Consultas extends JFrame {
    private JTextField cnpjField;
    private JButton searchButton;
    private JButton menuButton;
    private JButton logoffButton;

    private Connection connection;
    private Statement statement;

    public Consultas() {
        connectToDatabase();
        initComponents();
    }

    private void connectToDatabase() {
        try {
            // Carregando o driver JDBC para o SQLite
            Class.forName("org.sqlite.JDBC");

            // Estabelecendo a conexão com o banco de dados SQLite
            String url = "jdbc:sqlite:users.db";
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC não encontrado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
          JLabel subtitleLabel = new JLabel("Consulta CNPJ");
    subtitleLabel.setBounds(50, 20, 200, 30);
    add(subtitleLabel);

    JLabel cnpjLabel = new JLabel("CNPJ:");
    cnpjLabel.setBounds(10, 50, 50, 30);
    add(cnpjLabel);
        
        cnpjField = new JTextField();
        cnpjField.setBounds(50, 50, 200, 30);
        add(cnpjField);

        searchButton = new JButton("Pesquisar");
        searchButton.setBounds(50, 100, 100, 30);
        searchButton.addActionListener((ActionEvent evt) -> {
            pesquisarCliente();
        });
        add(searchButton);

        menuButton = new JButton("Menu");
        menuButton.setBounds(200, 100, 100, 30);
        menuButton.addActionListener((ActionEvent evt) -> {
            jButtonMenuActionPerformed(evt);
        });
        add(menuButton);

        logoffButton = new JButton("Logout");
        logoffButton.setBounds(350, 100, 100, 30);
        logoffButton.addActionListener((ActionEvent evt) -> {
            jButtonLogoutActionPerformed(evt);
        });
        add(logoffButton);

         pack();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setResizable(true);
         setLocationRelativeTo(null);
    }

    private void pesquisarCliente() {
        String cnpj = cnpjField.getText().trim();
        if (cnpj.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um CNPJ válido!");
            return;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clientes WHERE cnpj = ?");
            preparedStatement.setString(1, cnpj);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String telefone = resultSet.getString("telefone");
                String estado = resultSet.getString("estado");
                
                // Exibir os dados do cliente encontrados
                JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nEstado: " + estado);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta: " + e.getMessage());
        }
    }

    private void jButtonMenuActionPerformed(ActionEvent evt) {
        Menu menuScreen = new Menu();
        menuScreen.setVisible(true);
        dispose(); // Fechar a tela atual de clientes
    }

    private void jButtonLogoutActionPerformed(ActionEvent evt) {
        A3Laticinios loginScreen = new A3Laticinios();
        loginScreen.setVisible(true);
        loginScreen.setTitle("Login");
        dispose(); // Fechar a tela atual de clientes
        JOptionPane.showMessageDialog(this, "Logout realizado com sucesso");
    }

    public static void main(String[] args) {
        new Consultas();
    }
}

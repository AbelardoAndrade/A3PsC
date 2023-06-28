package com.mycompany.a3laticinios;


import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;

public final class Clientes extends javax.swing.JFrame {
     private Connection connection;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldCnpj;
    private JTextField jTextFieldTelefone;
    private JTextField jTextFieldEndereco;
    private JTextField jTextFieldEstado;
    private JButton jButtonPesquisar;
    private JButton jButtonMenu;
    private JButton jButtonLogout;
    private JButton jButtonRegistrar;
    private JButton jButtonLimpar;
    private JButton jButtonExcluir;
    
    
    public Clientes () {
       connectToDatabase();       
       initComponents();
        
    }
    
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabelNome = new JLabel();
        jTextFieldNome = new JTextField();
        JLabel jLabelCnpj = new JLabel();
        jTextFieldCnpj = new JTextField();
        JLabel jLabelTelefone = new JLabel();
        jTextFieldTelefone = new JTextField();
        JLabel jLabelEndereco = new JLabel();
        jTextFieldEndereco = new JTextField();
        JLabel jLabelEstado = new JLabel();
        jTextFieldEstado = new JTextField();
        jButtonPesquisar = new JButton();
        jButtonMenu = new JButton();
        jButtonLogout = new JButton();
        jButtonRegistrar = new JButton();
        jButtonLimpar = new JButton();
        jButtonExcluir = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabelNome.setText("Nome:");

        jLabelCnpj.setText("CNPJ:");

        jLabelTelefone.setText("Telefone:");

        jLabelEndereco.setText("Endereco:");

        jLabelEstado.setText("Estado:");
        

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener((ActionEvent evt) -> {
            jButtonPesquisarActionPerformed(evt);
        });

        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener((ActionEvent evt) -> {
            jButtonMenuActionPerformed(evt);
        });

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener((ActionEvent evt) -> {
            jButtonLogoutActionPerformed(evt);
        });
       
 
                // Configurar o botão "Registrar"
jButtonRegistrar.setText("Registrar");
jButtonRegistrar.addActionListener((ActionEvent evt) -> {
    jButtonRegistrarActionPerformed(evt);
        });
       jButtonLimpar.setText("Limpar"); // Botão Limpar
       jButtonLimpar.addActionListener((ActionEvent evt) -> {
           jButtonLimparActionPerformed(evt);
        });
       
         jButtonExcluir.setText("Excluir"); // Botão Excluir
        jButtonExcluir.addActionListener((ActionEvent evt) -> {
            jButtonExcluirActionPerformed(evt);
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogout)
                        .addComponent(jButtonRegistrar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)))
                    .addContainerGap(162, Short.MAX_VALUE))
       
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCnpj)
                    .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndereco)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstado)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonMenu)
                    .addComponent(jButtonLogout)
                    .addComponent(jButtonRegistrar)
                 .addComponent(jButtonLimpar)
                .addComponent(jButtonExcluir))
                
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setResizable(true);
         setLocationRelativeTo(null);
    }

   public void connectToDatabase() {
        try {
            // Carregando o driver JDBC para o SQLite
            Class.forName("org.sqlite.JDBC");

            // Estabelecendo a conexão com o banco de dados SQLite
            String url = "jdbc:sqlite:users.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC não encontrado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }

   private void jButtonPesquisarActionPerformed(ActionEvent evt) {
    String nome = jTextFieldNome.getText();
    String cnpj = jTextFieldCnpj.getText();
    String telefone = jTextFieldTelefone.getText();
    String endereco = jTextFieldEndereco.getText();
    String estado = jTextFieldEstado.getText();

    // Criação da query dinamicamente
    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM clientes WHERE 1=1");

 ArrayList<String> parameters = new ArrayList<>();
 ArrayList<Object> parameterValues = new ArrayList<>();
 
 

     String Nome = jTextFieldNome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um Nome válido!");
            return;
        }try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clientes WHERE nome = ?");
            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta: " + e.getMessage());
        }
 
  
    // Adiciona as cláusulas WHERE de acordo com os campos preenchidos
    if (!nome.isEmpty()) {
        queryBuilder.append(" AND nome = ?");
        parameters.add("nome");
        parameterValues.add(nome);
    }
    if (!cnpj.isEmpty()) {
        queryBuilder.append(" AND cnpj = ?");
        parameters.add("cnpj");
        parameterValues.add(cnpj);
    }
    if (!telefone.isEmpty()) {
        queryBuilder.append(" AND telefone = ?");
        parameters.add("telefone");
        parameterValues.add(telefone);
    }
    if (!endereco.isEmpty()) {
        queryBuilder.append(" AND endereco = ?");
        parameters.add("endereco");
        parameterValues.add(endereco);
    }
    if (!estado.isEmpty()) {
        queryBuilder.append(" AND estado = ?");
        parameters.add("estado");
        parameterValues.add(estado);
    }

    // Converte as listas para arrays
    String[] parameterArray = parameters.toArray(new String[0]);
    Object[] parameterValueArray = parameterValues.toArray();

    String query = queryBuilder.toString();

    try {
        // Preparar a declaração SQL
        PreparedStatement statement = connection.prepareStatement(query);

        // Definir os parâmetros da consulta
        for (int i = 0; i < parameterArray.length; i++) {
            statement.setObject(i + 1, parameterValueArray[i]);
        }

        // Executar a consulta
        ResultSet resultSet = statement.executeQuery();

        // Verificar se existem resultados
        if (resultSet.next()) {
            // Extrair os valores dos campos do resultado da consulta
            String nomeResult = resultSet.getString("nome");
            String cnpjResult = resultSet.getString("cnpj");
            String telefoneResult = resultSet.getString("telefone");
            String enderecoResult = resultSet.getString("endereco");
            String estadoResult = resultSet.getString("estado");

            // Exibir os resultados nos componentes da tela
            jTextFieldNome.setText(nomeResult);
            jTextFieldCnpj.setText(cnpjResult);
            jTextFieldTelefone.setText(telefoneResult);
            jTextFieldEndereco.setText(enderecoResult);
            jTextFieldEstado.setText(estadoResult);
        } else {
            // Caso não haja resultados, exibir uma mensagem ao usuário
            JOptionPane.showMessageDialog(this, "Nenhum resultado encontrado.");
        }

        // Fechar o resultado e a declaração SQL
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao realizar a consulta: " + e.getMessage());
    }
}


   private void jButtonRegistrarActionPerformed(ActionEvent evt) {
    String nome = jTextFieldNome.getText();
    String cnpj = jTextFieldCnpj.getText();
    String telefone = jTextFieldTelefone.getText();
    String endereco = jTextFieldEndereco.getText();
    String estado = jTextFieldEstado.getText();

    String query = "INSERT INTO clientes (nome, cnpj, telefone, endereco, estado) VALUES (?, ?, ?, ?, ?)";

    try {
        // Preparar a declaração SQLite
        PreparedStatement statement = connection.prepareStatement(query);

        // Definir os parâmetros da inserção
        statement.setString(1, nome);
        statement.setString(2, cnpj);
        statement.setString(3, telefone);
        statement.setString(4, endereco);
        statement.setString(5, estado);

        // Executar a inserção
        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao inserir registro.");
        }

        // Fechar a declaração SQLite
        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao realizar a inserção: " + e.getMessage());
    }    
}
   
   private void jButtonExcluirActionPerformed(ActionEvent evt) {
        String nome = jTextFieldNome.getText();
        String cnpj = jTextFieldCnpj.getText();

        String query = "DELETE FROM clientes WHERE nome = ? AND cnpj = ?";

        try {
            // Preparar a declaração SQLite
            PreparedStatement statement = connection.prepareStatement(query);

            // Definir os parâmetros da exclusão
            statement.setString(1, nome);
            statement.setString(2, cnpj);

            // Executar a exclusão
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum registro foi excluído.");
            }

            // Fechar a declaração SQLite
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao realizar a exclusão: " + e.getMessage());
        }
    }
   
   

    private void jButtonLimparActionPerformed(ActionEvent evt) {
        jTextFieldNome.setText("");
        jTextFieldCnpj.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldEstado.setText("");
    }
    
    
    
    private void jButtonMenuActionPerformed(ActionEvent evt) {
        Menu menuScreen = new Menu();
        menuScreen.setVisible(true);
        this.dispose(); // Fechar a tela atual de clientes
    }

    private void jButtonLogoutActionPerformed(ActionEvent evt) {
        A3Laticinios loginScreen = new A3Laticinios();
        loginScreen.setVisible(true);
        loginScreen.setTitle("Login");
        this.dispose(); // Fechar a tela atual de clientes
        JOptionPane.showMessageDialog(this, "Logout realizado com sucesso");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Clientes ().setVisible(true);
        });
    }
}


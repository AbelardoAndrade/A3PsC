package com.mycompany.a3laticinios;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public final class Vendas extends javax.swing.JFrame {
    private Connection connection;
    private JTextField jTextFieldIDCliente;
    private JTextField jTextFieldCodigoVenda;
    private JTextField jTextFieldRastreio;
    private JTextField jTextFieldValidade;
    private JTextField jTextFieldValor;
    private JButton jButtonPesquisar;
    private JButton jButtonMenu;
    private JButton jButtonLogout;
    private JButton jButtonRegistrar;
    private JButton jButtonLimpar;
    private JButton jButtonExcluir;

 public Vendas() {
        connectToDatabase();       
        initComponents();
    }
 
    String imagePath = "/logo.png";
    ImageIcon logoIcon = new ImageIcon(getClass().getResource(imagePath));

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabelIDCliente = new JLabel();
        jTextFieldIDCliente = new JTextField();
        JLabel jLabelCodigoVenda = new JLabel();
        jTextFieldCodigoVenda = new JTextField();
        JLabel jLabelRastreio = new JLabel();
        jTextFieldRastreio = new JTextField();
        JLabel jLabelValidade = new JLabel();
        jTextFieldValidade = new JTextField();
        JLabel jLabelValor = new JLabel();
        jTextFieldValor = new JTextField();
        jButtonPesquisar = new JButton();
        jButtonMenu = new JButton();
        jButtonLogout = new JButton();
        jButtonRegistrar = new JButton();
        jButtonLimpar = new JButton();
        jButtonExcluir = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         JLabel logoLabel = new JLabel(logoIcon);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Adiciona o logoLabel na posição central
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(0, 0, 20, 0); // Espaçamento inferior
        jPanel1.add(logoLabel, gbc);

        // Tamanho dos botões
        jButtonPesquisar.setPreferredSize(new java.awt.Dimension(100, 35));
        jButtonMenu.setPreferredSize(new java.awt.Dimension(100, 35));
        jButtonRegistrar.setPreferredSize(new java.awt.Dimension(100, 35));
        jButtonLimpar.setPreferredSize(new java.awt.Dimension(100, 35));
        jButtonLogout.setPreferredSize(new java.awt.Dimension(100, 35));


        jLabelIDCliente.setText("ID Cliente:");

        jLabelCodigoVenda.setText("Código de Venda:");

        jLabelRastreio.setText("Rastreio:");

        jLabelValidade.setText("Validade:");

        jLabelValor.setText("Valor:");
        

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButtonPesquisarActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });
       
 
                // Configurar o botão "Registrar"
jButtonRegistrar.setText("Registrar");
jButtonRegistrar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        jButtonRegistrarActionPerformed(evt);
    }
        });
       jButtonLimpar.setText("Limpar"); // Botão Limpar
       jButtonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
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
                        .addComponent(jLabelIDCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCodigoVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelRastreio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRastreio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelValidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogout)
                        .addComponent(jButtonRegistrar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar)
                     .addComponent(jButtonExcluir)))
                    .addContainerGap(162, Short.MAX_VALUE))
       
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDCliente)
                    .addComponent(jTextFieldIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigoVenda)
                    .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRastreio)
                    .addComponent(jTextFieldRastreio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValidade)
                    .addComponent(jTextFieldValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonMenu)
                    .addComponent(jButtonLogout)
                    .addComponent(jButtonRegistrar)
                 .addComponent(jButtonLimpar)
                .addComponent(jButtonExcluir))
                
                .addContainerGap(162, Short.MAX_VALUE))
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

   private void jButtonPesquisarActionPerformed(ActionEvent evt) throws SQLException {
    String idCliente = jTextFieldIDCliente.getText();
    String codigoVenda = jTextFieldCodigoVenda.getText();
    String rastreio = jTextFieldRastreio.getText();
    String validade = jTextFieldValidade.getText();
    String valor = jTextFieldValor.getText();

    // Criação da query dinamicamente
    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM vendas WHERE 1=1");

 ArrayList<String> parameters = new ArrayList<>();
 ArrayList<Object> parameterValues = new ArrayList<>();

     String idcliente = jTextFieldIDCliente.getText().trim();
        if (idcliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um ID válido!");
            return;
        }try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clientes WHERE cnpj = ?");
            preparedStatement.setString(1, idcliente);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta: " + e.getMessage());
        }
    // Adiciona as cláusulas WHERE de acordo com os campos preenchidos
    if (!idCliente.isEmpty()) {
        queryBuilder.append(" AND id_cliente = ?");
        parameters.add("id_cliente");
        parameterValues.add(idCliente);
    }
    if (!codigoVenda.isEmpty()) {
        queryBuilder.append(" AND codigo_venda = ?");
        parameters.add("codigo_venda");
        parameterValues.add(codigoVenda);
    }
    if (!rastreio.isEmpty()) {
        queryBuilder.append(" AND rastreio = ?");
        parameters.add("rastreio");
        parameterValues.add(rastreio);
    }
    if (!validade.isEmpty()) {
        queryBuilder.append(" AND validade = ?");
        parameters.add("validade");
        parameterValues.add(validade);
    }
    if (!valor.isEmpty()) {
        queryBuilder.append(" AND valor = ?");
        parameters.add("valor");
        parameterValues.add(valor);
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
            String idClienteResult = resultSet.getString("id_cliente");
            String codigoVendaResult = resultSet.getString("codigo_venda");
            String rastreioResult = resultSet.getString("rastreio");
            String validadeResult = resultSet.getString("validade");
            String valorResult = resultSet.getString("valor");

            // Exibir os resultados nos componentes da tela
            jTextFieldIDCliente.setText(idClienteResult);
            jTextFieldCodigoVenda.setText(codigoVendaResult);
            jTextFieldRastreio.setText(rastreioResult);
            jTextFieldValidade.setText(validadeResult);
            jTextFieldValor.setText(valorResult);
        } else {
            // Caso não haja resultados, exibir uma mensagem ao usuário
            JOptionPane.showMessageDialog(this, "Nenhuma venda encontrada.");
        }

        // Fechar o resultado e a declaração SQL
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao realizar a consulta: " + e.getMessage());
    }
}


   private void jButtonRegistrarActionPerformed(ActionEvent evt) {
    String idCliente = jTextFieldIDCliente.getText();
    String codigoVenda = jTextFieldCodigoVenda.getText();
    String rastreio = jTextFieldRastreio.getText();
    String validade = jTextFieldValidade.getText();
    String valor = jTextFieldValor.getText();

    String query = "INSERT INTO vendas (id_cliente, codigo_venda, rastreio, validade, valor) VALUES (?, ?, ?, ?, ?)";

    try {
        // Preparar a declaração SQL
        PreparedStatement statement = connection.prepareStatement(query);

        // Definir os parâmetros da inserção
        statement.setString(1, idCliente);
        statement.setString(2, codigoVenda);
        statement.setString(3, rastreio);
        statement.setString(4, validade);
        statement.setString(5, valor);

        // Executar a inserção
        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao inserir registro.");
        }

        // Fechar a declaração SQL
        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao realizar a inserção: " + e.getMessage());
    }
}

    private void jButtonLimparActionPerformed(ActionEvent evt) {
        jTextFieldIDCliente.setText("");
        jTextFieldCodigoVenda.setText("");
        jTextFieldRastreio.setText("");
        jTextFieldValidade.setText("");
        jTextFieldValor.setText("");
    }
    
    
    
    private void jButtonMenuActionPerformed(ActionEvent evt) {
        Menu menuScreen = new Menu();
        menuScreen.setVisible(true);
        this.dispose(); // Fechar a tela atual de vendas
    }
    
    private void jButtonExcluirActionPerformed(ActionEvent evt) {
        String idcliente = jTextFieldIDCliente.getText();
        String codigovenda = jTextFieldCodigoVenda.getText();
        String rastreio = jTextFieldRastreio.getText();
        String validade = jTextFieldValidade.getText();
        String valor = jTextFieldValor.getText();

        String query = "DELETE FROM vendas WHERE id_cliente = ? AND codigo_venda = ? AND rastreio = ? AND validade = ? AND valor = ?" ;

        try {
            // Preparar a declaração SQLite
            PreparedStatement statement = connection.prepareStatement(query);

            // Definir os parâmetros da exclusão
            statement.setString(1, idcliente);
            statement.setString(2, codigovenda);
            statement.setString(3, rastreio);
            statement.setString(4, validade);
            statement.setString(5, valor);

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
    
    

    private void jButtonLogoutActionPerformed(ActionEvent evt) {
        A3Laticinios loginScreen = new A3Laticinios();
        loginScreen.setVisible(true);
        loginScreen.setTitle("Login");
        this.dispose(); // Fechar a tela atual de vendas
        JOptionPane.showMessageDialog(this, "Logout realizado com sucesso");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Vendas().setVisible(true);
        });
    }
}


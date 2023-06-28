
package com.mycompany.a3laticinios;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class A3Laticinios extends javax.swing.JFrame {
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField1;

    public A3Laticinios() {
        initComponents();
    }

    String imagePath = "/logo.png";
    ImageIcon logoIcon = new ImageIcon(getClass().getResource(imagePath));

    private void initComponents() {
        
        
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setPreferredSize(new Dimension(150, 25));
     
        
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField1.setPreferredSize(new Dimension(150, 25));
        
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        
        
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

        
        
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jButton2.setText("New User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        // Posiciona os componentes de login
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new java.awt.Insets(0, 0, 10, 10); // Espaçamento inferior e à direita
        jPanel1.add(jLabel1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 50); // Espaçamento inferior
        jPanel1.add(jTextField1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new java.awt.Insets(0, -50, 10, 0); // Espaçamento inferior e à direita
        jPanel1.add(jLabel2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 0, 10, 50); // Espaçamento inferior
        jPanel1.add(jPasswordField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.insets = new java.awt.Insets(10, 50, 0, 50); // Espaçamento superior
        jPanel1.add(jButton1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(10, 50, 0, 50); // Espaçamento superior
        jPanel1.add(jButton2, gbc); 
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
                
        );
        
         
    
        pack();
        
        // Centraliza a janela no meio da tela
        setLocationRelativeTo(null);
       
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Add any custom handling for the "Usuário" field if needed
    }

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Add any custom handling for the "Senha" field if needed
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

        if (authenticate(username, password)) {
            // Login successful, establish database connection
            connectToDatabase();
            // Perform desired actions or open new screen
            Menu menu;
            menu = new Menu();
            menu.setVisible(true);
            
            System.out.println("Login successful");
        } else {
    System.out.println("Invalid username or password");
    JOptionPane.showMessageDialog(this, "Nome de usuário ou senha inválido", "Erro de login", JOptionPane.ERROR_MESSAGE);
        }}


    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());

         if (username.isEmpty() || password.isEmpty()) {
        // Exibir uma mensagem de alerta se algum dos campos estiver vazio
        JOptionPane.showMessageDialog(this, "Por favor, preencha ambos os campos.", "Alerta", JOptionPane.WARNING_MESSAGE);
    } else 
        
        if (createUser(username, password)) {
            System.out.println("Novo usuário criado com sucesso: " + username);


            // Close current login screen if needed
            this.dispose();

            // Exibir uma mensagem para o usuário informando que o novo usuário foi criado com sucesso
            JOptionPane.showMessageDialog(this, "Novo usuário criado com sucesso: " + username);
            
             // Criar uma nova instância da tela de login
            A3Laticinios loginScreen = new A3Laticinios();
            loginScreen.setVisible(true);

            // Fechar a tela atual de cadastro de usuário
            this.dispose();
            
        } else {
            System.out.println("Erro ao criar novo usuário");
            // Exibir uma mensagem de erro caso ocorra algum problema ao criar o novo usuário
            JOptionPane.showMessageDialog(this, "Erro ao criar novo usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean createUser(String username, String password) {
        try {
            // Estabelecer conexão com o banco de dados SQLite
            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.db");

            // Verificar se o usuário já existe no banco de dados
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
 if (username.isEmpty() || password.isEmpty()) {
        // Exibir uma mensagem de alerta se algum dos campos estiver vazio
        JOptionPane.showMessageDialog(this, "Por favor, preencha ambos os campos.", "Alerta", JOptionPane.WARNING_MESSAGE);
    } else 
            // Se o usuário já existe, retornar falso e exibir uma mensagem de erro
            if (resultSet.next()) {
                System.out.println("Usuário já existe: " + username);
                return false;
            }

            // Inserir o novo usuário no banco de dados
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            int rowsAffected = insertStatement.executeUpdate();

            // Verificar se o novo usuário foi criado com sucesso
            if (rowsAffected > 0) {
                // Fechar recursos
                resultSet.close();
                statement.close();
                insertStatement.close();
                connection.close();
                return true;
            } else {
                System.out.println("Erro ao criar novo usuário");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar novo usuário: " + e.getMessage());
            return false;
        }
    }

    public void connectToDatabase() {
        try {
            // Carregando o driver JDBC para o SQLite
            Class.forName("org.sqlite.JDBC");

            // Estabelecendo a conexão com o banco de dados SQLite
            String url = "jdbc:sqlite:users.db";
            DriverManager.getConnection(url);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC não encontrado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }

    private boolean authenticate(String username, String password) {
        try {
            // Estabelecer conexão com o banco de dados SQLite
            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.db");

            // Consultar o banco de dados para verificar as credenciais
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            // Verificar se o usuário e senha correspondem
            boolean authenticated = resultSet.next();
            System.out.println("Authenticated: " + authenticated);

            // Fechar recursos
            resultSet.close();
            statement.close();
            connection.close();

            return authenticated;
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar o usuário: " + e.getMessage());
            return false;
        }
    }
    
    

 public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            A3Laticinios a3Laticinios = new A3Laticinios();
            a3Laticinios.pack();
            a3Laticinios.setSize(400, 700);
            a3Laticinios.setLocationRelativeTo(null);
            a3Laticinios.setResizable(false); // Desativa o redimensionamento da janela
            a3Laticinios.setVisible(true);
        }
    });
}

  
}
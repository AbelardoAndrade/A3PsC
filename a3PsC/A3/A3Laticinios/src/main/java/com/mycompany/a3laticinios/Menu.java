package com.mycompany.a3laticinios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Menu extends javax.swing.JFrame {
    
    private javax.swing.JButton jButtonCliente;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonVendas;
    private javax.swing.JPanel jPanel1;
   
    public Menu() {
        initComponents();
    }

    
    private void initComponents() {
    jPanel1 = new javax.swing.JPanel();
    jButtonVendas = new javax.swing.JButton();
    jButtonCliente = new javax.swing.JButton();
    jButtonConsulta = new javax.swing.JButton();
    jButtonLogout = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/logo.png")));

    // Adiciona o logoLabel na posição central
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new java.awt.Insets(0, 0, 20, 0); // Espaçamento inferior
    jPanel1.add(logoLabel, gbc);

    jButtonVendas.setText("Vendas");
    jButtonVendas.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jButtonVendasActionPerformed(evt);
        }
    });

    jButtonCliente.setText("Cliente");
    jButtonCliente.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jButtonClienteActionPerformed(evt);
        }
    });

    jButtonConsulta.setText("Consulta");
    jButtonConsulta.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jButtonConsultaActionPerformed(evt);
        }
    });

    jButtonLogout.setText("Logout");
    jButtonLogout.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            jButtonLogoutActionPerformed(evt);
        }
    });
    
    

    
    //tamanho dos botoes
    jButtonVendas.setPreferredSize(new java.awt.Dimension(100, 35));
    jButtonCliente.setPreferredSize(new java.awt.Dimension(100, 35));
    jButtonConsulta.setPreferredSize(new java.awt.Dimension(100, 35));
    jButtonLogout.setPreferredSize(new java.awt.Dimension(100, 35));
    
   
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new java.awt.Insets(20, 0, 0, 0); // Espaçamento superior
    jPanel1.add(jButtonVendas, gbc);

    gbc.gridy = 2;
    jPanel1.add(jButtonCliente, gbc);

    gbc.gridy = 3;
    jPanel1.add(jButtonConsulta, gbc);

    gbc.gridy = 4;
    gbc.insets = new java.awt.Insets(20, 0, 0, 0); // Espaçamento superior
    jPanel1.add(jButtonLogout, gbc);

    setLayout(new BorderLayout());
    add(jPanel1, BorderLayout.CENTER);

    pack();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setResizable(true);
    setLocationRelativeTo(null);
}
    
    
    
    
    private void jButtonVendasActionPerformed(java.awt.event.ActionEvent evt) {
        Vendas vendasScreen = new Vendas();
        vendasScreen.setVisible(true);

        this.setVisible(false);
    }

    private void jButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {
        Clientes clientesScreen = new Clientes();
        clientesScreen.setVisible(true);

        this.setVisible(false);
    }

    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {
        Consultas consultasScreen = new Consultas();
        consultasScreen.setVisible(true);

        this.setVisible(false);
    }

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        A3Laticinios loginScreen = new A3Laticinios();
        loginScreen.setVisible(true);
        loginScreen.setTitle("Login");

        this.dispose();

        JOptionPane.showMessageDialog(this, "Logout realizado com sucesso");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu menu = new Menu();
                menu.setVisible(true);
            }
            
        });
        
    }
    
}


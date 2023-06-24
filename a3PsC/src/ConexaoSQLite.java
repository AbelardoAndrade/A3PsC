import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/A3_PSC_DATABASE.db";

        // Estabelecendo a conexão
        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("Conexão com o banco de dados estabelecida.");

            // Executando uma consulta
            try ( // Criando uma declaração (Statement) para executar consultas SQL
                    Statement statement = connection.createStatement()) {
                // Executando uma consulta
                String sql = "SELECT * FROM Cliente";
                // Processando o resultado da consulta
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    // Processando o resultado da consulta
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ID_CLT");
                        String nome = resultSet.getString("NM_CLT");
                        int cnpj = resultSet.getInt("CNPJ_CLT");
                        String endereco = resultSet.getString("END_CLT");
                        
                        System.out.println("ID: " + id);
                        System.out.println("Nome: " + nome);
                        System.out.println("CNPJ: " + cnpj);
                        System.out.println("Endereço: " + endereco);
                        System.out.println("------------------------");
                    }
                    // Fechando o ResultSet, o Statement e a conexão
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }
}

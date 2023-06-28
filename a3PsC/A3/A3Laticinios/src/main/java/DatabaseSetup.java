import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        try {
            // Estabelecer conexão com o banco de dados SQLite
            Connection connection;
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");

            try ( // Criar tabela de usuários
                    Statement statement = connection.createStatement()) {
                String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL, password TEXT NOT NULL)";
                statement.executeUpdate(createTableQuery);
                // Inserir usuário mestre
                String adminUsername = "admin";
                String adminPassword = "admin";
                String insertAdminQuery = String.format("INSERT INTO users (username, password) VALUES ('%s', '%s')", adminUsername, adminPassword);
                statement.executeUpdate(insertAdminQuery);
                // Fechar conexão com o banco de dados
            }
            connection.close();

            System.out.println("Banco de dados criado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar o banco de dados: " + e.getMessage());
        }
    }
}

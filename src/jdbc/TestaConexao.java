package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection =  connectionFactory.RecuperaConexao();

        System.out.println("Fechando a conexão!!!");
        //Fechando o banco de dados
        connection.close();

    }
}
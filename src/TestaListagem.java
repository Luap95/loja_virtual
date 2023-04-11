import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection =  connectionFactory.RecuperaConexao();
        
        //Criando e executando Statement para consulta do banco de dados
        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM PRODUTO");
        //Recebendo o resultado da consulta
        ResultSet resultSet = statement.getResultSet();
        //Percorrendo e imprimindo todos os registros da consulta
        while (resultSet.next()){
            Integer id = resultSet.getInt("ID");
            System.out.println(id);
            String nome = resultSet.getString("NOME");
            System.out.println(nome);
            String descricao = resultSet.getString("DESCRICAO");
            System.out.println(descricao);
        }

        System.out.println("Fechando a conexão!!!");
        //Fechando a conexão
        connection.close();
    }
}

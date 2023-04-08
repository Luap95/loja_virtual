import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root", "bd@Lucas95");

        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM PRODUTO");

        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()){
            Integer id = resultSet.getInt("ID");
            System.out.println(id);
            String nome = resultSet.getString("NOME");
            System.out.println(nome);
            String descricao = resultSet.getString("DESCRICAO");
            System.out.println(descricao);
        }

        System.out.println("Fechando a conexão!!!");

        connection.close();
    }
}

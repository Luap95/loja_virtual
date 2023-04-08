import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        //Abrindo uma conexão com o banco de dados preenchendo as informações do tipo, usuário e senha
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root", "bd@Lucas95");

        System.out.println("Fechando a conexão!!!");
        //Fechando o banco de dados
        connection.close();

    }
}
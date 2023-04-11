import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection RecuperaConexao() throws SQLException {
        //Abrindo uma conexão com o banco de dados preenchendo as informações do tipo, usuário e senha
        return DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
                        "root", "bd@Lucas95");
    }
}

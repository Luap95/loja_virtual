import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        //Criando uma nova conexão ao banco de dados
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.RecuperaConexao();
        //Criando e executando um Statement para remoção de registros no banco de dados
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM PRODUTO WHERE id > 2");
        //Contando o numero de registros que foram modificados
        int linhasModificadas = statement.getUpdateCount();
        //Imprimindo a quantidade de linhas modificadas
        System.out.println("O total de linhas modicadas: " + linhasModificadas);
    }
}

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        //Recuperando uma conexão ao banco de dados
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.RecuperaConexao();
        //Criando uma Statement para executar comando de inserção do SQL
        Statement statement = connection.createStatement();
        //Execução retorna chave
        statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')",
                Statement.RETURN_GENERATED_KEYS);
        //Atribuindo a chave retornada ao ResultSet
        ResultSet resultSet = statement.getGeneratedKeys();
        //Listando as chaves criadas
        while (resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado para o produto é " + id);
        }
    }
}

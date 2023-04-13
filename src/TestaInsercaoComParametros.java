import java.sql.*;

public class TestaInsercaoComParametros {
    public static void main(String[] args) throws SQLException {
        //Variaveis com dados que serão inseridos
        String nome = "Mouse";
        String descricao = "Mouse sem fio";

        //Recuperando uma conexão ao banco de dados
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.RecuperaConexao();

        //Criando um PreparedStatement e definindo quais são os parâmetros com "?"
        PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) " +
                        "VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS);

        //Definindo quais serão dados que representarão o parâmetros
        statement.setString(1, nome);
        statement.setString(2, descricao);

        //Execução retorna chave
        statement.execute();

        //Atribuindo a chave retornada ao ResultSet
        ResultSet resultSet = statement.getGeneratedKeys();
        //Listando as chaves criadas
        while (resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado para o produto é " + id);
        }
        System.out.println("Fechando a conexão!!!");
        //Fechando a conexão
        connection.close();
    }
}

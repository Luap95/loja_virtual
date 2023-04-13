import java.sql.*;

public class TestaInsercaoComParametros {
    public static void main(String[] args) throws SQLException {

        //Recuperando uma conexão ao banco de dados
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.RecuperaConexao();
        //Tirando o poder de commit do JDBC
        connection.setAutoCommit(false);

        try{
            //Criando um PreparedStatement e definindo quais são os parâmetros com "?"
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) " +
                    "VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS);

            adicionaVariavel("SmartTV", "45 polegadas", statement);
            adicionaVariavel("Radio", "Radio de bateria", statement);

            //Confimando as operações pendentes
            connection.commit();
        } catch (Exception e){
            //Imprimindo o tipo de erro
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            //Executando o rollback
            connection.rollback();
        }
        //Fechando o banco de dados
        connection.close();
    }

    private static void adicionaVariavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
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
        resultSet.close();
    }
}

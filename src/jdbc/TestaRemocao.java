package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        //Criando uma nova conexão ao banco de dados
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.RecuperaConexao()){
            //Preparando um Statement para remoção de registros no banco de dados
            PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE id > ?");
            //definindo o valor do parâmetro
            statement.setInt(1, 2);
            //Executando o Statement
            statement.execute();
            //Contando o numero de registros que foram modificados
            int linhasModificadas = statement.getUpdateCount();
            //Imprimindo a quantidade de linhas modificadas
            System.out.println("O total de linhas modicadas: " + linhasModificadas);
            System.out.println("Fechando a conexão!!!");
        }

    }
}

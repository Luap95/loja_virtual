package teste;

import jdbc.dao.ProdutoDAO;
import jdbc.modelo.Produto;
import jdbc.ConnectionFactory;

import java.sql.*;

public class TestaInsercaoComProduto {

    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda vertical");

        try(Connection connection = new ConnectionFactory().RecuperaConexao()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
        }
        System.out.println(comoda);
    }
}

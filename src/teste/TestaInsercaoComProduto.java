package teste;

import dao.ProdutoDAO;
import modelo.Produto;
import factory.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class TestaInsercaoComProduto {

    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda vertical");

        try(Connection connection = new ConnectionFactory().RecuperaConexao()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);

            List<Produto> produtos = produtoDAO.listar();

//            for (Produto produto : produtos) {
//
//                System.out.println(produto);
//            }
            produtos.stream().forEach(lp -> System.out.println(lp));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(comoda);



    }
}

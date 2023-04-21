package teste;

import jdbc.ConnectionFactory;
import jdbc.dao.CategoriaDAO;
import jdbc.modelo.Categoria;
import jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = new ConnectionFactory().RecuperaConexao()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();

            listaDeCategorias.stream().forEach(categoria -> {
                System.out.println(categoria.getNome());
                for(Produto produto : categoria.getProdutos()){
                    System.out.println(categoria.getNome()+ " - " + produto.getNome());
                }
            });
        }

    }
}

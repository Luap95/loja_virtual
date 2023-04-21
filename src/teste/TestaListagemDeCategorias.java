package teste;

import jdbc.ConnectionFactory;
import jdbc.dao.CategoriaDAO;
import jdbc.modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = new ConnectionFactory().RecuperaConexao()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listar();

            listaDeCategorias.stream().forEach(categoria -> System.out.println(categoria.getNome()));
        }

    }
}

package jdbc.dao;

import jdbc.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;
    public CategoriaDAO(Connection connection){
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "SELECT * FROM CATEGORIA";

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    Categoria categoria = new Categoria();

                    categoria.setId(resultSet.getInt(1));
                    categoria.setNome(resultSet.getString(2));

                    categorias.add(categoria);
                }
            }
        }
        return categorias;
    }
}

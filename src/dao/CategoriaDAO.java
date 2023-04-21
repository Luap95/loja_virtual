package dao;

import modelo.Categoria;
import modelo.Produto;

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

    public List<Categoria> listar()  {
        try {
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
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Categoria> listarComProdutos() throws SQLException{
        List<Categoria> categorias = new ArrayList<Categoria>();
        Categoria ultima = null;
        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C " +
                "INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.execute();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    //Não lista categorias repetidas
                    if(ultima==null||!ultima.getNome().equals(resultSet.getString(2))){
                        Categoria categoria = new Categoria();

                        categoria.setId(resultSet.getInt(1));
                        categoria.setNome(resultSet.getString(2));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto = new Produto();
                    produto.setId(resultSet.getInt(3));
                    produto.setNome(resultSet.getString(4));
                    produto.setDescricao(resultSet.getString(5));

                    ultima.adiciona(produto);
                }
            }
        }
        return categorias;
    }
}

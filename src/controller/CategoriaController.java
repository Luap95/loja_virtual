package controller;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    CategoriaDAO categoriaDAO;

    public CategoriaController() {
        Connection connection = new ConnectionFactory().RecuperaConexao();
        this.categoriaDAO = new CategoriaDAO(connection);

    }
    public List<Categoria> listar() {
        return this.categoriaDAO.listar();
    }
}

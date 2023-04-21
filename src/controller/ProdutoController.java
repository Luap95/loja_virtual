package controller;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import modelo.Produto;

import java.sql.Connection;
import java.util.List;

public class ProdutoController {
    ProdutoDAO produtoDAO;

    public ProdutoController(){
        Connection connection = new ConnectionFactory().RecuperaConexao();
        this.produtoDAO = new ProdutoDAO(connection);
    }
    public void deletar(Integer id) {
        produtoDAO.deletar(id);
    }

    public void salvar(Produto produto) {
        produtoDAO.salvar(produto);
    }

    public List<Produto> listar() {
        return this.produtoDAO.listar();
    }

    public void alterar(String nome, String descricao, Integer id) {
        this.produtoDAO.alterar(nome,descricao,id);
    }
}

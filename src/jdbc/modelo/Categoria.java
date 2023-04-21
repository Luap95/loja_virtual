package jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int id;
    private String nome;

    private List<Produto> produtos = new ArrayList<Produto>();

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adiciona(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}

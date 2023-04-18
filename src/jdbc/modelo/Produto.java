package jdbc.modelo;

public class Produto {

    private int id;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Id: " + this.id + "\n" +
                "Nome: " + this.nome + "\n" +
                "Descrição: " + this.descricao;
    }
}

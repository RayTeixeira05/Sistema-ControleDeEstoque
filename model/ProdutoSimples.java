package model;

public class ProdutoSimples extends Produto {

    public ProdutoSimples(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "Produto";
    }
}

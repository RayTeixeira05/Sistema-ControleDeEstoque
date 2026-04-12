package model;

public abstract class Produto {
    private String nome;
    private int quantidade;

    public Produto(String nome) {
        this.nome = nome;
        this.quantidade = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade >= 0) {
        this.quantidade = quantidade;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void entrada(int qtd) {
        if(qtd > 0) {
        quantidade += qtd;
        }
    }

   public void saida(int qtd) {
        if (qtd <= 0) {
            System.out.println("Quantidade invalida!");
        } else if (qtd > quantidade) {
            System.out.println("Estoque insuficiente!");
        } else {
            quantidade -= qtd;
        }
    }
        public abstract String getTipo();
}
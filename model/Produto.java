package model;

public abstract class Produto {
    private String nome;
    private int quantidade;
    private int id;

    private static int contador = 1;

    public Produto(String nome) {
        if(nome != null && !nome.isEmpty()) {
        this.nome = nome;
        }
        this.quantidade = 0;
        this.id = contador++;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()) {
        this.nome = nome;
        }
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

    public int getId() { 
        return id; 
    }
    public void setId(int id) {
        this.id = id;
        if (id >= contador) {
            contador = id + 1;
        }
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

   @Override
    public String toString() {
        return "ID: " + id + " | " + nome + " | Tipo: " + getTipo() +" | Qtd: " + quantidade;
    }
}
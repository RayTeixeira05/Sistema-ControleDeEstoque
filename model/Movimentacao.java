package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimentacao {

    public static final String ENTRADA = "ENTRADA";
    public static final String SAIDA = "SAIDA";

    private int produtoId;
    private String tipo;
    private int quantidade;
    private LocalDateTime data;

    public Movimentacao(int produtoId, String tipo, int quantidade) {
        this.produtoId = produtoId;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
    }

    public Movimentacao(int produtoId, String tipo, int quantidade, LocalDateTime data) {
        this.produtoId = produtoId;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return data.format(formato) + " | Produto: " + produtoId + " | " + tipo + " | Qtd: " + quantidade;
    }
}
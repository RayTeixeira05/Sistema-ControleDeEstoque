package service;

import model.Movimentacao;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MovimentacaoTXT {

    private static final String ARQUIVO = "movimentacoes.txt";

    public void salvar(ArrayList<Movimentacao> lista) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {

            for (Movimentacao m : lista) {

                writer.write(m.getProdutoId() + ";" + m.getTipo() + ";" + m.getQuantidade() + ";" + m.getData());

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar movimentações.");
        }
    }

    public ArrayList<Movimentacao> carregar() {

        ArrayList<Movimentacao> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");

                int produtoId = Integer.parseInt(dados[0]);

                String tipo = dados[1];

                int quantidade = Integer.parseInt(dados[2]);

                LocalDateTime data = LocalDateTime.parse(dados[3]);

                lista.add(new Movimentacao(produtoId, tipo, quantidade, data));
            }

        } catch (IOException e) {
            System.out.println("Arquivo de movimentações não encontrado.");
        }
        return lista;
    }
}
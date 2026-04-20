package service;

import model.*;
import java.io.*;
import java.util.ArrayList;

public class EstoqueTXT {

    private static final String ARQUIVO = "estoque.txt";

    public void salvar(ArrayList<Produto> produtos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {

            for (Produto p : produtos) {
                writer.write(p.getId() + ";" + p.getNome() + ";" + p.getQuantidade());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar");
        }
    }

    public ArrayList<Produto> carregar() {
        ArrayList<Produto> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] p = linha.split(";");

                Produto prod = new ProdutoSimples(p[1]);
                prod.setId(Integer.parseInt(p[0]));
                prod.setQuantidade(Integer.parseInt(p[2]));

                lista.add(prod);
            }

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");
        }

        return lista;
    }
}
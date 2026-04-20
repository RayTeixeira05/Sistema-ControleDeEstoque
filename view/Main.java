package view;

import model.*;
import service.Estoque;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

    int op;

        do {
            System.out.println("\n1 - Cadastrar Produto");
            System.out.println("2 - Cadastrar Maquinario");
            System.out.println("3 - Entrada");
            System.out.println("4 - Saida");
            System.out.println("5 - Listar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                Produto novo = new ProdutoSimples(nome);
                estoque.adicionarProduto(novo);
                System.out.println("Cadastrado com ID: " + novo.getId());
            break;

            case 2:
                System.out.print("Nome: ");
                String nomeM = sc.nextLine();

                System.out.print("ID Maquina: ");
                String idM = sc.nextLine();
                Produto novoM = new Maquinario(nomeM, idM);
                estoque.adicionarProduto(novoM);
                System.out.println("Cadastrado com ID: " + novoM.getId());
            break;

            case 3:
                System.out.print("ID do produto: ");
                int idE = sc.nextInt();
                Produto pE = estoque.buscarPorId(idE);
                if (pE != null) {
                    System.out.print("Qtd: ");
                    pE.entrada(sc.nextInt());
                    estoque.salvar();
                }
            break;

            case 4:
                System.out.print("ID do produto: ");
                int idS = sc.nextInt();
                Produto pS = estoque.buscarPorId(idS);
                if (pS != null) {
                    System.out.print("Qtd: ");
                    pS.saida(sc.nextInt());
                    estoque.salvar();
                    }
            break;

            case 5:
                estoque.listar();
            break;
        }

    } while (op != 0);

        sc.close();
    }
}
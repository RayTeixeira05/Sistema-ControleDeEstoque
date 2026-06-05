package view;

import model.*;
import service.Estoque;
import service.MovimentacaoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();


        MovimentacaoService movService = new MovimentacaoService();

        int op;

        do {
            System.out.println("\n1 - Cadastrar Produto");
            System.out.println("2 - Cadastrar Maquinario");
            System.out.println("3 - Entrada");
            System.out.println("4 - Saida");
            System.out.println("5 - Listar");
            System.out.println("6 - Remover Produto");
            System.out.println("7 - Historico");
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
                Produto novoM = new Maquinario(nomeM);
                estoque.adicionarProduto(novoM);
                System.out.println("Cadastrado com ID: " + novoM.getId());
            break;

            case 3:
                System.out.print("ID do produto: ");
                int idE = sc.nextInt();

                Produto pE = estoque.buscarPorId(idE);

                if (pE != null) {
                    System.out.print("Qtd: ");
                    int qtd = sc.nextInt();
                    pE.entrada(qtd);

                    movService.registrar(new Movimentacao(pE.getId(),Movimentacao.ENTRADA,qtd));

                    estoque.salvar();

                    System.out.println("Entrada realizada com sucesso!");

                } else {
                    System.out.println("Produto não encontrado!");
                }
              break;

            case 4:
                System.out.print("ID do produto: ");
                int idS = sc.nextInt();

                Produto pS = estoque.buscarPorId(idS);

                if (pS != null) {

                    System.out.print("Qtd: ");
                    int qtd = sc.nextInt();

                    pS.saida(qtd);

                    movService.registrar(new Movimentacao(pS.getId(),Movimentacao.SAIDA, qtd));

                    estoque.salvar();

                } else {
                    System.out.println("Produto não encontrado!");
                }
            break;

            case 5:
                estoque.listar();
            break;
        
            case 6:
                System.out.print("ID do produto: ");
                int idR = sc.nextInt();

                if (estoque.removerProduto(idR)) {
                    System.out.println("Produto removido!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
            break;

            case 7:
             movService.listar();
            break;
        }   
    } while (op != 0);

        sc.close();
    }
}
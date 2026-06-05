package service;

import model.Movimentacao;
import java.util.ArrayList;

public class MovimentacaoService {

    private ArrayList<Movimentacao> movimentacoes;
    private MovimentacaoTXT dao = new MovimentacaoTXT();

    public MovimentacaoService() {
        movimentacoes = dao.carregar();
    }

    public void registrar(Movimentacao movimentacao) {

        movimentacoes.add(movimentacao);
        dao.salvar(movimentacoes);
    }

    public void listar() {

        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentação.");
            return;
        }

        for (Movimentacao m :movimentacoes) {
        System.out.println(m);
        }

    }
}
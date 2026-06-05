package service;
import service.EstoqueTXT;
import model.Produto;
import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> produtos;
    private EstoqueTXT dao = new EstoqueTXT();

    public Estoque() {
        produtos = dao.carregar();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
        salvar();
    }


    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public boolean removerProduto(int id) {
        Produto p = buscarPorId(id);

        if(p != null) {
            produtos.remove(p);
            salvar();
            return true;
        }
        return false;
    }

    public boolean editarNome(int id, String novoNome) {

        Produto p = buscarPorId(id);

        if (p != null) {
            p.setNome(novoNome);
            salvar();
            return true;
        }
        return false;
    }
    public boolean editarQuantidade(int id, int novaQuantidade) {

        Produto p = buscarPorId(id);

        if (p != null) {
            p.setQuantidade(novaQuantidade);
            salvar();
            return true;
        }
        return false;
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public void salvar() {
        dao.salvar(produtos);
    }
}
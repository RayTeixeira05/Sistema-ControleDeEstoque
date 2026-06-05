package model;
public class Maquinario extends Produto {

    public Maquinario(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "Maquinario";
    }
}
package model;

public class Maquinario extends Produto{
    private String identificador;

    public Maquinario(String nome, String identificador) {
        super(nome);
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        if(identificador != null && !identificador.isEmpty()) {
            this.identificador = identificador;
        }
    }
    @Override
    public String getTipo() {
        return "Maquinario";
    }
}
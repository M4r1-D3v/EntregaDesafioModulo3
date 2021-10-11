package br.com.zup;

public class Vendedor extends Pessoa {
    private String ctps;

    public Vendedor() {
    }

    public Vendedor(String nome, String cpf, String email, String ctps) {
        super(nome, cpf, email);
        this.ctps = ctps;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\n Nome: " + getNome());
        retorno.append("\n Cpf: " + getCpf());
        retorno.append("\n Email: " + getEmail());
        retorno.append("\n CTPS: " + ctps);
        retorno.append("\n -------------------");
        return retorno.toString();

    }
}

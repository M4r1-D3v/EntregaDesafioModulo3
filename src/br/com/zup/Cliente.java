package br.com.zup;

public class Cliente extends Pessoa{
    private String endereco;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\n Nome: " + getNome());
        retorno.append("\n Cpf: " + getCpf());
        retorno.append("\n Email: " + getEmail());
        retorno.append("\n Endereço: " + endereco);
        retorno.append("\n -------------------");
        return retorno.toString();
    }

}

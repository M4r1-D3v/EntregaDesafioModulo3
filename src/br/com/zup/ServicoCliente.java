package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoCliente {
    private static List<Cliente> clientes = new ArrayList<>(); //Instanciar lista de Clientes

    public static Cliente cadastrarCliente(String nome, String cpf, String email, String endereco) throws Exception { //método para cadastrar um cliente
        validarEmailClt(email);
        verificarExistenciaEmail(email);
        verificarExistenciaCpfCliente();
        Cliente cliente = new Cliente(nome, cpf, email, endereco);
        clientes.add(cliente);
        return cliente;
    }

    public static void verificarExistenciaCpfCliente(String cpf) throws Exception { // método para verificar se o cliente já está cadastrado através do cpf
        for (Cliente cpfCltVerificacao : clientes) {
            if (cpfCltVerificacao.getCpf().equals(cpf)) {
                throw new Exception("Cpf já cadastrado no sistema");
            }

        }
    }

    public static void validarEmailClt(String emailClt) throws Exception { //método para verificar se email do cliente é válido
        if (!emailClt.contains("@")) {
            throw new Exception("E-mail inválido.");
        }
    }

    public static void verificarExistenciaEmail(String email) throws Exception { //método verificar se email do clt é cadastrado
        for (Cliente emailReferenciaClt : clientes) {
            if (emailReferenciaClt.getEmail().equals(email)) {
                throw new Exception("E-mail já cadastrado no sistema.");
            }

        }
    }

    public static Cliente procurarClienteCpf(String cpfRecebido) throws Exception { //método para procurar o cliente pelo cpf
        for (Cliente clienteProcurado : clientes) {
            if (clienteProcurado.getCpf().equals(cpfRecebido)) {
                return clienteProcurado;
            }


        }
        throw new Exception("Cliente não cadastrado no sistema.");
    }

    public static void imprimirCliente() {
        for (Cliente referencia : clientes) {
            System.out.println(referencia);
        }
    }


}
package br.com.zup;

import java.util.Scanner;

public class Sistema {
    private static Scanner entradaDados(String mensagem) { //método para receber os dados do usuário
        System.out.println(mensagem);
        return new Scanner(System.in);
    }
    public static Cliente cadastrarCliente(){
        System.out.println("----------------------------");
        System.out.println("Cadastrar Cliente: ");
        System.out.println("----------------------------");
        String nomeCliente = entradaDados("Por favor, digite o nome do cliente: ").nextLine();
        String cpfCliente = entradaDados("Por favor, digite o cpf do cliente: ").nextLine();
        String emailCliente = entradaDados("Por favor, digite o email do cliente: ").nextLine();
        String endereco = entradaDados("Por favor, digite o endereço do cliente: ").nextLine();
        return ServicoCliente.cadastrarCliente(nomeCliente, cpfCliente, emailCliente, endereco);

    }

}

package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoCliente {
    private static List<Cliente> clientes = new ArrayList<>(); //Instanciar lista de Clientes

    public static Cliente cadastrarCliente(String nome, String cpf, String email, String endereco){ //método para cadastrar um cliente
        Cliente cliente = new Cliente(nome, cpf,email,endereco);
        clientes.add(cliente);
        return cliente;
    }


}
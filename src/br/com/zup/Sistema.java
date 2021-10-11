package br.com.zup;

import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static Scanner entradaDados(String mensagem) { //método para receber os dados do usuário
        System.out.println(mensagem);
        return new Scanner(System.in);
    }
    public static Cliente cadastrarCliente()throws Exception{   //método para receber os dados para cadastro do cliente
        System.out.println("----------------------------");
        System.out.println("Cadastrar Cliente: ");
        System.out.println("----------------------------");
        String nomeCliente = entradaDados("Por favor, digite o nome do cliente: ").nextLine();
        String cpfCliente = entradaDados("Por favor, digite o cpf do cliente: ").nextLine();
        String emailCliente = entradaDados("Por favor, digite o email do cliente: ").nextLine();
        String endereco = entradaDados("Por favor, digite o endereço do cliente: ").nextLine();
        return ServicoCliente.cadastrarCliente(nomeCliente, cpfCliente, emailCliente, endereco);

    }

    public static Vendedor cadastrarVendedor() throws Exception { //método para cadastrar vendedor
        System.out.println("----------------------------");
        System.out.println("Cadastrar Vendedor: ");
        System.out.println("----------------------------");
        String nomeVendedor = entradaDados("Por favor, digite o nome do vendedor: ").nextLine();
        String cpfVendedor = entradaDados("Por favor, digite o cpf do vendedor: ").nextLine();
        String emailVendedor = entradaDados("Por favor, digite o email do vendedor: ").nextLine();
        String ctps = entradaDados("Por favor, digite a ctps do vendedor: ").nextLine();
        return ServicoVendedor.cadastrarVendedor(nomeVendedor, cpfVendedor, emailVendedor, ctps);

    }
    public static Venda cadastrarVenda() throws Exception { //método para cadastrar venda
        System.out.println("----------------------------");
        System.out.println("Cadastrar Venda: ");
        System.out.println("----------------------------");
        String emailVendedor = entradaDados("Por favor, digite o email do Vendedor: ").nextLine();
        String cpfCliente = entradaDados("Por favor, digite o cpf do Cliente: ").nextLine();
        double valorPago = entradaDados("Por favor, digite o valor: ").nextDouble();
        String dataRegistro = entradaDados("Por favor,digite a data de registro da venda:").nextLine();

        return ServicoVenda.cadastrarVenda(emailVendedor, cpfCliente, valorPago, dataRegistro);

    }

    public static List<Venda> pesquisarVendasVendedorEmail() throws Exception { //método para listar vendas do vendedor a partir do e-mail
        String emailVendedor = entradaDados("Por favor, digite o email do vendedor: ").nextLine();
        ServicoVendedor.validarEmailVendedor(emailVendedor); //validar email do vendedor antes de pesquisar lista de vendas
        List<Venda> totalVendasVendedor = ServicoVenda.pesquisarVendasVendedorEmail(emailVendedor);
        return totalVendasVendedor;

    }

    public static List<Venda> pesquisarComprasClienteCpf() throws Exception { //método para listar as compras do cliente pelo cpf
        String cpfCliente = entradaDados("Por favor, digite o cpf do cliente: ").nextLine();
        List<Venda> totalComprasCliente = ServicoVenda.pesquisarComprasClienteCpf(cpfCliente);
        return totalComprasCliente;
    }

}

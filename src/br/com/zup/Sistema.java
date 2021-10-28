package br.com.zup;

import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static Scanner entradaDados(String mensagem) { //método para receber os dados do usuário
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static void menu() { //método para exibir as opções do menu
        System.out.println("\n ");
        System.out.println("**********************************************************");
        System.out.println("Seja bem vinde ao sistema de vendas da empresa !ReturNull!");
        System.out.println("**********************************************************");
        System.out.println("\n ");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para cadastrar um cliente, digite             [1]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para cadastrar um vendendor, digite           [2]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para cadastrar uma venda, digite              [3]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para listar os clientes cadastrados, digite   [4]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para listar os vendedores cadastrados, digite [5]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para listar as vendas cadastradas, digite     [6]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para listar as compras cadastradas, digite    [7]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para listar as vendas de um vendedor, digite  [8]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para listar as compras de um cliente, digite  [9]");
        System.out.println("---------------------------------------------------");
        System.out.println("# Para sair do sistema, digite                 [10]");

    }

    public static Cliente cadastrarCliente() throws Exception {   //método para receber os dados para cadastro do cliente
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

    public static boolean executar() throws Exception {
        boolean operarMenu = true;

        while (operarMenu) {
            menu();
            System.out.println("---------------------------------------------------");
            int escolhaUsuario = entradaDados("Escolha uma opção: ").nextInt();
            if (escolhaUsuario == 1) {
                Cliente cliente = new Cliente();
                try {
                    cliente = cadastrarCliente();
                    System.out.println("\n");
                    System.out.println("Cliente cadastrado com sucesso!");
                } catch (Exception erro) {
                    System.out.println(erro.getMessage());
                    cliente = cadastrarCliente();
                }

            } else if (escolhaUsuario == 2) {
                Vendedor vendedor = new Vendedor();
                try {
                    vendedor = cadastrarVendedor();
                    System.out.println("\n");
                    System.out.println("Vendedor cadastrado com sucesso!");
                } catch (Exception erro) {
                    System.out.println(erro.getMessage());
                    vendedor = cadastrarVendedor();
                }
            } else if (escolhaUsuario == 3) {
                Venda venda = cadastrarVenda();
                System.out.println("\n");
                System.out.println("Venda cadastrada com sucesso!");
                System.out.println(venda);
            } else if (escolhaUsuario == 4) {
                ServicoCliente.imprimirCliente();
            } else if (escolhaUsuario == 5) {
                ServicoVendedor.listarVendedor();
            } else if (escolhaUsuario == 6) {
                ServicoVenda.listarVendas();
            } else if (escolhaUsuario == 7) {
                ServicoVenda.listarCompras();
            } else if (escolhaUsuario == 8) {
                List<Venda> totalVendas = pesquisarVendasVendedorEmail();
                System.out.println(totalVendas);
            } else if (escolhaUsuario == 9) {
                List<Venda> totalCompras = pesquisarComprasClienteCpf();
                System.out.println(totalCompras);
            } else if (escolhaUsuario == 10) {
                System.out.println("Obrigade e até a próxima!");
                operarMenu = false;

            } else {
                System.out.println("[[Oops! Digite uma opção válida.]]");
                System.out.println("\n \n");
            }
        }
        return operarMenu;
    }

}

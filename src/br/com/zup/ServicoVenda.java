package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVenda {
    private static List<Venda> vendas = new ArrayList<>();

    public static Venda cadastrarVenda(String emailVendedor, String cpfCliente, double valorPago, String dataRegistro) throws Exception {//cadastrar venda
        Cliente cliente = ServicoCliente.procurarClienteCpf(cpfCliente);
        Vendedor vendedor = ServicoVendedor.procurarVendedorEmail(emailVendedor);

        Venda venda = new Venda(cliente, vendedor, valorPago, dataRegistro);
        vendas.add(venda);
        return venda;
    }

    public static List<Venda> pesquisarVendasVendedorEmail(String email) { //lista todas as vendas do vendedor pelo email dele.
        List<Venda> listaVendasVendedor = new ArrayList();
        for (Venda vendasPesquisadas : vendas) {
            if (vendasPesquisadas.getVendedor().getEmail().equals(email)) {
                listaVendasVendedor.add(vendasPesquisadas);
            }

        }
        return listaVendasVendedor;
    }

    public static List<Venda> pesquisarComprasClienteCpf(String cpfCliente) { //lista todas as compras do cliente pelo cpf dele.
        List<Venda> listaComprasCliente = new ArrayList<>();
        for (Venda comprasPesquisadas : vendas) {
            if (comprasPesquisadas.getCliente().getCpf().equals(cpfCliente)) {
                listaComprasCliente.add(comprasPesquisadas);
            }

        }
        return listaComprasCliente;
    }

    public static void listarVendas() { //lista das vendas totais

        for (Venda qtdTotalVendas : vendas) {

            System.out.println(qtdTotalVendas);

        }
    }

    public static void listarCompras() { //lista das compras totais

        for (Venda qtdeTotalCompras : vendas) {
            System.out.println(qtdeTotalCompras);

        }

    }

}

package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoVendedor {
    private static List<Vendedor> vendedores = new ArrayList<>();

    public static void validarEmailVendedor(String emailVendedor) throws Exception { //verificar se email é válido (com @)
        if (!emailVendedor.contains("@")) {
            throw new Exception("E-mail inválido.");
        }
    }

    public static void verificarExistenciaEmailVendedor(String email) throws Exception { //verificar se o email é repetido
        for (Vendedor emailReferenciaVendedor : vendedores) {
            if (emailReferenciaVendedor.getEmail().equals(email)) {
                throw new Exception("E-mail já cadastrado no sistema");
            }

        }
    }

    public static void verificarExistenciaCpfVendedor(String cpf) throws Exception { //verificar se o cpf do vendedor já está cadastrado
        for (Vendedor cpfReferenciaVendedor : vendedores) {
            if (cpfReferenciaVendedor.getCpf().equals(cpf)) {
                throw new Exception("Cpf já cadastrado no sistema");
            }

        }
    }

    public static Vendedor cadastrarVendedor(String nome, String cpf, String email, String ctps) throws Exception { //cadastrar vendedor com regras de negócio aplicadas
        validarEmailVendedor(email);
        verificarExistenciaEmailVendedor(email);
        verificarExistenciaCpfVendedor(cpf);
        Vendedor vendedor = new Vendedor(nome, cpf, email, ctps);
        vendedores.add(vendedor);
        return vendedor;
    }

    public static Vendedor procurarVendedorEmail(String emailRecebido) throws Exception { //verificar se o vendedor já está cadastrado no sistema através do email
        for (Vendedor emailVendedorProcurado : vendedores) {
            if (emailVendedorProcurado.getEmail().equals(emailRecebido)) {
                return emailVendedorProcurado;
            }

        }
        throw new Exception("Vendedor não cadastrado no sistema.");
    }

    public static void listarVendedor() {
        List<Vendedor> totalVendedores = new ArrayList<>();
        for (Vendedor qtdeVendedores : vendedores) {
            totalVendedores.add(qtdeVendedores);
            System.out.println(totalVendedores);
        }

    }

}

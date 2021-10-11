package br.com.zup;


public class Venda {
    private Cliente cliente;
    private Vendedor vendedor;
    private double valorPago;
    private String dataRegistro;

    public Venda(Cliente cliente, Vendedor vendedor, double valorPago, String dataRegistro) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valorPago = valorPago;
        this.dataRegistro = dataRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\n Cliente: " + getCliente());
        retorno.append("\n Vendedor: " + getVendedor());
        retorno.append("\n Venda: ");
        retorno.append("\n Valor Pago: " + valorPago);
        retorno.append("\n Data de registro: " + dataRegistro);
        return retorno.toString();
    }

}

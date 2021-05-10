package Classes;

import java.time.LocalDate;

public class Venda implements Comparable<Venda>{
    private LocalDate dataDaVenda;
    private String produtoVendido;
    private int quantidadeVendida;
    private int valorDaVenda;

    
    public Venda(int valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }
    public int getValorDaVenda() {
        return valorDaVenda;
    }
    public void setValorDaVenda(int valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }
    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }
    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
    public String getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    @Override
    public String toString() {
        return "Venda [dataDaVenda=" + dataDaVenda + ", produtoVendido=" + produtoVendido + ", quantidadeVendida="
                + quantidadeVendida + ", valorDaVenda=" + valorDaVenda + "]";
    }
    public Venda(LocalDate dataVend, String prodVend, int quantVend, int valorVend, int valorUniVend) {
        this.dataDaVenda = dataVend;
        this.produtoVendido = prodVend;
        this.quantidadeVendida = quantVend;
        this.valorDaVenda = valorVend;
    }
    @Override
    public int compareTo(Venda o) {
        
        return 0;
    }
    
    
    }

 

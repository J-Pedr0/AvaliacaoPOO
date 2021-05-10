package Classes;

import java.time.LocalDate;

public class Produto implements Comparable<Produto>{
    private int codigoProduto;
    private String nomeProduto;
    private int valorProduto;
    private int quantidadeEmEstoqueProduto;
    
    public int getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public int getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(int valorProduto) {
        this.valorProduto = valorProduto;
    }
    public int getQuantidadeEmEstoqueProduto() {
        return quantidadeEmEstoqueProduto;
    }
    public void setQuantidadeEmEstoqueProduto(int quantidadeEmEstoqueProduto) {
        this.quantidadeEmEstoqueProduto = quantidadeEmEstoqueProduto;
    }
    public Produto(int codigoProduto, String nomeProduto, int valorProd, int quantidadeEmEstoqueProduto) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProd;
        this.quantidadeEmEstoqueProduto = quantidadeEmEstoqueProduto;
    }
    
    public Produto(int cod, String nomeProd, int valorProd, int quantidadeEstoque, LocalDate parse) {
	}
	@Override
    public String toString() {
        return String.format("Código do produto: %s / Nome do produto: %s / Valor unitário do produto: %s / Quantidade do produto em estoque: %s",
         codigoProduto, nomeProduto, valorProduto, quantidadeEmEstoqueProduto );

        

        /*"Código do produto = " + codigoProduto +
         ", Nome do produto = " + nomeProduto +
          ", Quantidade do produto em estoque = " + quantidadeEmEstoqueProduto +
           ", Valor unitário do produto = " + valorProduto;*/
    }
    @Override
    public int compareTo(Produto o) {
        return getNomeProduto().compareTo(o.getNomeProduto());
    }
    
}
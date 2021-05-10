package Programa;

import java.time.LocalDate;
/*import java.time.LocalDateTime;*/
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/*import java.util.Collection;*/
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Classes.Produto;
import Classes.Venda;

public class ProgramaProduto {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();
        DateTimeFormatter dF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;
        int opcao2;
        int opcao3;
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("\n****************");
            System.out.println("*     Menu     *");
            System.out.println("*   Principal  *");
            System.out.println("****************");
            System.out.println("\n|----------------------------|");
            System.out.println("| 1 – Cadastro de produtos   |");
            System.out.println("| 2 – Relatórios             |");
            System.out.println("| 3 – Realizar venda         |");
            System.out.println("| 0 – Sair                   |");
            System.out.println("|----------------------------|");
            opcao = ler.nextInt();
            ler.nextLine();


            switch(opcao){
            case 1:

                do {
                System.out.println("\n****************");
                System.out.println("*   Cadastro   *");
                System.out.println("*      de      *");
                System.out.println("*   Produtos   *");
                System.out.println("****************");
                System.out.println("|-----------------------------|");
                System.out.println("| 1 – Consultar               |");
                System.out.println("| 2 – Incluir                 |");
                System.out.println("| 0 – Voltar ao menu anterior |");
                System.out.println("|-----------------------------|");
                opcao2 = ler.nextInt();
                ler.nextLine();
                
                switch(opcao2){

                     case 1:
                    if (produtos.isEmpty()) {
                        System.out.println("\n*****************************************************");
                        System.out.println("*   Infelizmente não há nenhum produto cadastrado.  *");
                        System.out.println("*****************************************************");
                        } else {
                            System.out.println("\n*****************");
                            System.out.println("*   Consultar   *");
                            System.out.println("*****************");
                            System.out.println("\nDigite o nome do produto:");
                            String buscaProduto = ler.nextLine();
                            List<Produto> prodBuscado = produtos.stream()
            .filter(p -> p.getNomeProduto().contains(buscaProduto))
            .collect(Collectors.toList());

            prodBuscado.forEach(System.out::println);
                        }
                break;

                     case 2:
                int cod;
                do {
                System.out.println("\n***************");
                System.out.println("*   Incluir   *");
                System.out.println("***************");
                System.out.println("\nDigite aqui o código do produto ou 0 para encerrar: ");
                cod = ler.nextInt();
                ler.nextLine();

                if (cod != 0) {
                System.out.println("\nDigite o nome do protudo que deseja adicionar:");
                String nomeProd = ler.nextLine();
                System.out.println("Digite o valor desse protudo:");
                int valorProd = ler.nextInt();
                System.out.println("Digite a quantidade em estoque desse protudo:");
                int quantidadeEstoque = ler.nextInt();
                ler.nextLine();
                produtos.add(new Produto(cod, nomeProd, valorProd, quantidadeEstoque));
                }
                
                }while (cod != 0);

                break;

                     case 0: 
                System.out.println("Voltando...");
                break;
                }

                } while (opcao2 != 0);

                break;

            case 2:
                do {
                    System.out.println("\n**************");
                    System.out.println("* Relatórios *");
                    System.out.println("**************");
                    System.out.println("\n|**************************************|");
                    System.out.println("| 1 – Produtos                         |");
                    System.out.println("| 2 – Vendas por período – detalhado   |");
                    System.out.println("| 3 – Vendas por período – consolidado |");
                    System.out.println("| 0 – Voltar ao menu anterior          |");
                    System.out.println("|**************************************|");
                    opcao3 = ler.nextInt();
                    ler.nextLine();
                    
                    switch(opcao3){

                         case 1:
                        if (produtos.isEmpty()) {
                        System.out.println("\n*****************************************************");
                        System.out.println("*   Infelizmente não há nenhum produto cadastrado.  *");
                        System.out.println("*****************************************************");
                            } else {
                            System.out.println("\n****************");
                            System.out.println("*   Produtos   *");
                            System.out.println("****************");
                            for (Produto produto : produtos) {
                            System.out.println(produto); 
                            System.out.println("**************************");
                            IntSummaryStatistics dados = produtos.stream()
                            .collect(Collectors.summarizingInt(Produto::getValorProduto)); 
                            

                            System.out.println("Valor médio: " + dados.getAverage() + ", valor máximo: " + dados.getMax()
                            + ", valor mínimo: " + dados.getMin());
                            System.out.println("**************************");
                            }}
                        break;
                         case 2:
                         System.out.println("\n*****************");
                         System.out.println("*    Vendas     *");
                         System.out.println("*     Por       *");
                         System.out.println("*    Período    *");
                         System.out.println("*   Detalhado   *");
                         System.out.println("*****************");

                         System.out.println("\n|--------------------------------------|");
                         System.out.println("|Informe o período de emissão desejado:|");
                         System.out.println("|--------------------------------------|");
                         
                         String dataIni;
                         String dataFin;

                         System.out.println("\nDigite a data inicial:");
                         dataIni = ler.nextLine();
                         System.out.println("Digite a data final:");
                         dataFin = ler.nextLine();

                         LocalDate dataInicial = LocalDate.parse(dataIni, dF);
                         LocalDate dataFinal = LocalDate.parse(dataFin, dF); 

                         System.out.println("\n*****************");
                         System.out.println("*    Vendas     *");
                         System.out.println("*     Por       *");
                         System.out.println("*    Período    *");
                         System.out.println("*   Detalhado   *");
                         System.out.println("*****************");
                         System.out.printf("Data inicial: %s \nDana final: %s", dataIni, dataFin);

                         System.out.printf(
                             "\n%-13.13s\t%-15.15s\t%-10.10s\t%-11.11s\n",
                             "Data da venda", "Nome do produto", "Quantidade", "Valor total");
                        

                         List<Venda> vendasFiltradas = 
                         vendas.stream().filter(v -> 
                         v.getDataDaVenda().plusDays(1).isAfter(dataInicial) &&
                         v.getDataDaVenda().plusDays(-1).isBefore(dataFinal))
                         .collect(Collectors.toList());

                         vendasFiltradas.forEach(v -> System.out.printf(
                            "%-13.13s\t%-15.15s\t%-10.10s\t%-11.11s\n",
                             v.getDataDaVenda().format(dF), v.getProdutoVendido(), v.getQuantidadeVendida(), v.getValorDaVenda()));


                             DoubleSummaryStatistics est = vendasFiltradas.stream()
                             .collect(Collectors.summarizingDouble(v -> v.getValorDaVenda()));
                             System.out.println(est);
                             
                        break;
                        case 3:
                        System.out.println("\n*******************");
                         System.out.println("*    Vendas      *");
                         System.out.println("*     Por        *");
                         System.out.println("*    Período     *");
                         System.out.println("*  Consolidado   *");
                         System.out.println("*****************");

                         System.out.println("\n|--------------------------------------|");
                         System.out.println("|Informe o período de emissão desejado:|");
                         System.out.println("|--------------------------------------|");
                         
                         String dataIni2;
                         String dataFin2;

                         System.out.println("\nDigite a data inicial:");
                         dataIni2 = ler.nextLine();
                         System.out.println("Digite a data final:");
                         dataFin2 = ler.nextLine();

                         LocalDate dataInicial2 = LocalDate.parse(dataIni2, dF);
                         LocalDate dataFinal2 = LocalDate.parse(dataFin2, dF); 

                         System.out.println("\n*******************");
                         System.out.println("*    Vendas      *");
                         System.out.println("*     Por        *");
                         System.out.println("*    Período     *");
                         System.out.println("*  Consolidado   *");
                         System.out.println("*****************");
                         System.out.printf("Data inicial: %s \nDana final: %s", dataIni2, dataFin2);

                         System.out.printf(
                             "\n%-13.13s\t%-15.15s\t%-10.10s\t%-11.11s\n",
                             "Data da venda", "Nome do produto", "Quantidade", "Valor total");
                        

                         List<Venda> vendasFiltradas2 = 
                         vendas.stream().filter(v -> 
                         v.getDataDaVenda().plusDays(1).isAfter(dataInicial2) &&
                         v.getDataDaVenda().plusDays(-1).isBefore(dataFinal2))
                         .collect(Collectors.toList());

                         vendasFiltradas2.forEach(v -> System.out.printf(
                            "%-13.13s\t%-15.15s\t%-10.10s\t%-11.11s\n",
                             v.getDataDaVenda().format(dF), v.getProdutoVendido(), v.getQuantidadeVendida(), v.getValorDaVenda()));


                             DoubleSummaryStatistics est2 = vendasFiltradas2.stream()
                             .collect(Collectors.summarizingDouble(v -> v.getValorDaVenda()));
                             System.out.println(est2);
                             
                        break;
                         case 0: 
                System.out.println("Voltando...");
                break;
                    }
                }while (opcao3 != 0);
                break;

            case 3:
            String bucPro; 

                    System.out.println("******************");
                    System.out.println("* Realizar venda *");
                    System.out.println("******************");

                    System.out.println("\n****************************");
                    System.out.println("* Para realizar a venda... *");
                    System.out.println("****************************");

                    System.out.println("Digite a data para cadastro  da venda no formato dd/mm/aaaa");
                    String dataVend = ler.nextLine();

                    System.out.println("\nDigite o Nome do produto:");
                    bucPro = ler.nextLine();
                    for (Produto produto : produtos) {
                        if (produto.getNomeProduto().equalsIgnoreCase(bucPro)) {
                            System.out.printf("Produto: [%s] Valor: [%s]",
                             produto.getNomeProduto(), produto.getValorProduto());
                             if(produto.getQuantidadeEmEstoqueProduto() == 0) {
                                 System.out.println("Produto com quantidade zerada.");
                                 return;
                             } else {
                                System.out.printf("\nQuantidade em estoque desse proguto: [%s]", 
                                produto.getQuantidadeEmEstoqueProduto());
                                 System.out.println("\nDigite a quantidade desejada do produto para a venda:");
                                 int quantVend = ler.nextInt();
                                 if(quantVend <= produto.getQuantidadeEmEstoqueProduto()) {
                                     produto.setQuantidadeEmEstoqueProduto(produto.getQuantidadeEmEstoqueProduto() - quantVend);

                                 } else {
                                     System.out.println("Não tem quantidade sufisiente no estoque.");
                                 }
                                 int valorVend = (quantVend * produto.getValorProduto());
                                 String prodVend = produto.getNomeProduto();
                                 int valorUniVend = produto.getValorProduto();

                                 vendas.add(new Venda(LocalDate.parse(dataVend, dF), prodVend, quantVend, valorVend, valorUniVend));

                                 System.out.printf("\nProduto: [%s] \nQuantidade do produto: [%s] \n Valor total: [%s]",
                                 prodVend, quantVend, valorVend);
                             }
                            
                            
                        }
                    }
               
                break;

                case 0:
                  System.out.println("Metendo o pé...");
                  return;
                default:
                  System.out.println("Errou a opção, preste atenção.");
            }

        } while (opcao != 0);

        ler.close();

    }
}


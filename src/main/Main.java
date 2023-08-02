package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Pessoa> pessoas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);



    public void cadastrarPessoa(){
        System.out.println("Digite o nome da pessoa:");
        String nome = sc.nextLine();
        System.out.println("Digite a idade da pessoa:");
        int idade = sc.nextInt();
        List<Endereco> enderecos = new ArrayList<>();
        System.out.println("Quantos endereços essa pessoa tem?");
        int qtdEndereco = sc.nextInt();
        sc.nextLine();

        for (int j = 1; j <= qtdEndereco; ++j) {
            System.out.println("Digite o nome e o número do " + j + "º endereço dessa pessoa");
            String enderecoNome = sc.nextLine();
            int enderecoNumero = sc.nextInt();
            sc.nextLine();
            enderecos.add(new Endereco(enderecoNome, enderecoNumero));
        }
        pessoas.add(new Pessoa(nome, idade, enderecos));
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void exibirPedidosAbertos(List<Pessoa> pessoas) {
    for (Pessoa pessoa : pessoas) {
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Endereços:");

        List<Endereco> enderecos = pessoa.getEnderecos();
        for (Endereco endereco : enderecos) {
            System.out.println("Rua: " + endereco.getRua());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println();
        }

        Pedido pedidoEmAberto = pessoa.getPedidoEmAberto();
        if (pedidoEmAberto != null) {
            System.out.println("Pedido em aberto:");
            System.out.println("Tamanho: " + pedidoEmAberto.getTamanho());
            System.out.println("Sabores: " + pedidoEmAberto.getSabores());
        }

        List<Pedido> pedidosFeitos = pessoa.getPedidosFeitos();
        if (!pedidosFeitos.isEmpty()) {
            System.out.println("Pedidos feitos:");
            for (Pedido pedido : pedidosFeitos) {
                System.out.println("Tamanho: " + pedido.getTamanho());
                System.out.println("Sabores: " + pedido.getSabores());
                System.out.println();
            }
        }

        System.out.println("\n\n\n");
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void exibirNomes() {
        System.out.println("Pessoas cadastradas:");
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            System.out.println((i + 1) + ". " + pessoa.getNome());
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void exibirMenu(){
        System.out.println("==========Pizzaria Massa==========");
        System.out.println("1 - Alhobresa");
        System.out.println("2 - Calabresa");
        System.out.println("3 - Frango com Catupiry");
        System.out.println("4 - Marguerita");
        System.out.println("5 - Milho com Bacon");
        System.out.println("6 - Mista");
        System.out.println("7 - Mussarela");
        System.out.println("8 - Portuguesa");
        System.out.println("9 - Quatro queijos");
        System.out.println("10 - Strogonoff de Carne");
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void realizarPedido() {
    String tamanho = "";
    String[] saboresDisponiveis = {"Alhobresa", "Calabresa", "Frango com Catupiry", "Marguerita", "Milho com Bacon", "Mista", "Mussarela", "Portuguesa", "Quatro queijos", "Strogonoff de Carne"};
    System.out.println("==========Pizzaria Massa==========");
    System.out.println("Escolha o tamanho da sua pizza");
    System.out.println("1 - Pequena      2 - Media      3 - Grande");
    int escolha = sc.nextInt();

    switch (escolha) {
        case 1:
            tamanho = "Pequena";
            break;
        case 2:
            tamanho = "Media";
            break;
        case 3:
            tamanho = "Grande";
            break;
        default:
            tamanho = "tamanho nao escolhido";
    }

    System.out.println("Escolha a quantidade de sabores da sua pizza");
    System.out.println("1 - 1 Sabor      2 - 2 Sabores      3 - 3 Sabores");
    int quantidade = sc.nextInt();
    sc.nextLine(); // Pra nao pular linha de inserir

    List<String> saboresEscolhidos = new ArrayList<>();
    for (int i = 1; i <= quantidade; i++) {
        exibirMenu();
        System.out.println("Escolha o " + i + "º sabor");
        int numeroSabor = sc.nextInt();
        sc.nextLine(); // Pra nao pular linha de inserir

        if (numeroSabor >= 1 && numeroSabor <= saboresDisponiveis.length) {
            saboresEscolhidos.add(saboresDisponiveis[numeroSabor - 1]);
            System.out.println("O sabor escolhido foi: " + saboresDisponiveis[numeroSabor - 1]);
        } else {
            System.out.println("Número de sabor inválido. Escolha novamente.");
            i--; // Repetir a iteração para escolher outro sabor
        }
    }

    verificarCadastro();
    System.out.println("Pessoa  cadastrada");

    exibirNomes();

    System.out.println("Digite o número da pessoa para associar o pedido:");
    int numeroPessoa = sc.nextInt();
    sc.nextLine();

    if (numeroPessoa >= 1 && numeroPessoa <= pessoas.size()) {
        Pessoa pessoaEscolhida = pessoas.get(numeroPessoa - 1);
        Pedido pedido = new Pedido(tamanho, saboresEscolhidos);
        pessoaEscolhida.setPedidoEmAberto(pedido);
        pessoaEscolhida.addPedidoFeito(pedido);
        pessoaEscolhida.setPedido(pedido);
        System.out.println("Pedido associado à pessoa: " + pessoaEscolhida.getNome());
        DocumentoTxt(pessoas,pessoaEscolhida.getNome());
    } else {
        System.out.println("Número de pessoa inválido. Pedido não associado.");

    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void verificarCadastro(){
    int cadastro;
    System.out.println("Voce ja possui cadastro na loja?\n 1 - Sim     2 - Nao");
    cadastro = sc.nextInt();
    sc.nextLine();
    if (cadastro == 1){

    }
    else{
    cadastrarPessoa();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void pedidoAcabado(List<Pessoa> pessoas) {
    if (pessoas.isEmpty()) {
        System.out.println("Nenhuma pessoa cadastrada.");
    } else {
        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("Endereços:");

            List<Endereco> enderecos = pessoa.getEnderecos();
            for (Endereco endereco : enderecos) {
                System.out.println("Rua: " + endereco.getRua());
                System.out.println("Número: " + endereco.getNumero());
                System.out.println();
            }

            List<Pedido> pedidosFeitos = pessoa.getPedidosFeitos();
            if (pedidosFeitos.isEmpty()) {
                System.out.println("Nenhum pedido feito ainda ");
            } else {
                String primeiroTamanho = pedidosFeitos.get(0).getTamanho();
                System.out.println("Tamanho da Pizza do primeiro pedido: " + primeiroTamanho);
                Pedido primeiroPedido = pedidosFeitos.get(0);
                System.out.println("Sabores do primeiro pedido: " + primeiroPedido.getSabores());
                System.out.println();
            }

            System.out.println("\n\n\n");
        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void DocumentoTxt(List<Pessoa> pessoas,String indexPedido){
    boolean encontrou = false;
    for (Pessoa pessoa : pessoas){
        if(pessoa.getNome().equalsIgnoreCase(indexPedido)) {
            String nomeArquivo = "Pedido_" + indexPedido + ".txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
                writer.println("Pedido do: " + indexPedido);

                List<Endereco> enderecos = pessoa.getEnderecos();
                for (Endereco endereco : enderecos) {
                    writer.println("Rua: " + endereco.getRua());
                    writer.println("Número: " + endereco.getNumero());
                }
                List<Pedido> pedidos = (List<Pedido>) pessoa.getPedidosFeitos();
                String primeiroTamanho = pedidos.get(0).getTamanho();
                writer.println("Tamanho da Pizza: " + primeiroTamanho);
                Pedido primeiroPedido = pedidos.get(0);
                writer.println("Sabores do primeiro pedido: " + primeiroPedido.getSabores());
                writer.flush();
                System.out.println("Arquivo " + nomeArquivo + " gerado !");
            } catch (IOException e) {
                System.out.println("Erro ao gerar o documento .txt: " + e.getMessage());
            }
            break;
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Main obj = new Main();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        //Menu
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Cadastrar um pessoa");
            System.out.println("2. Exibir Menu");
            System.out.println("3. Realizar um Pedido");
            System.out.println("4. Ver pedidos Finalizados");
            System.out.println("5. Sair ");

            System.out.print("Escolha a opção desejada: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    obj.cadastrarPessoa();
                    break;
                case 2:
                    obj.exibirMenu();
                    break;
                case 3:
                    obj.realizarPedido();
                    break;
                case 4:
                    obj.exibirPedidosAbertos(obj.pessoas);
                    break;
                case 5:
                    obj.pedidoAcabado(obj.pessoas);
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
            }
        }while (opcao!=5);
    }
}
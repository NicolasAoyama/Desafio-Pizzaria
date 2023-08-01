package main;

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
    public void exibirPessoas(List<Pessoa> pessoas) {
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
            System.out.println("\n\n\n");
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
    String[] saboresDisponiveis = {"Alhobresa", "Calabresa", "Frango com Catupiry", "Marguerita", "Milho com Bacon", "Mista", "Mussarela", "Portuguesa", "Quatro queijos", "Strogonoff de Carne"};
    System.out.println("==========Pizzaria Massa==========");
    System.out.println("Escolha o tamanho da sua pizza");
    System.out.println("1 - Pequena      2 - Media      3 - Grande");
    int escolha = sc.nextInt();
    String tamanho = "";
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
    sc.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

    List<String> saboresEscolhidos = new ArrayList<>();
    for (int i = 1; i <= quantidade; i++) {
        exibirMenu();
        System.out.println("Escolha o " + i + "º sabor");
        int numeroSabor = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

        if (numeroSabor >= 1 && numeroSabor <= saboresDisponiveis.length) {
            saboresEscolhidos.add(saboresDisponiveis[numeroSabor - 1]);
            System.out.println("O sabor escolhido foi: " + saboresDisponiveis[numeroSabor - 1]);
        } else {
            System.out.println("Número de sabor inválido. Escolha novamente.");
            i--; // Repetir a iteração para escolher outro sabor
        }
    }

    System.out.println("Digite o nome da pessoa:");
    String nome = sc.nextLine();
    System.out.println("Digite a idade da pessoa:");
    int idade = sc.nextInt();
    sc.nextLine();

    List<Endereco> enderecos = new ArrayList<>();
    System.out.println("Quantos endereços essa pessoa tem?");
    int qtdEndereco = sc.nextInt();
    sc.nextLine();

    for (int j = 1; j <= qtdEndereco; j++) {
        System.out.println("Digite o nome e o número do " + j + "º endereço dessa pessoa");
        String enderecoNome = sc.nextLine();
        int enderecoNumero = sc.nextInt();
        sc.nextLine();
        enderecos.add(new Endereco(enderecoNome, enderecoNumero));
    }

    Pedido pedido = new Pedido(tamanho, saboresEscolhidos); // Substitua "Tamanho escolhido" pelo tamanho selecionado
    Pessoa pessoa = new Pessoa(nome, idade, enderecos, pedido);
    pessoas.add(pessoa);
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
            System.out.println("2. Exibir informacoes sobre as pessoas");
            System.out.println("3. Exibir Menu");
            System.out.println("4. Realizar um pedido");
            System.out.println("5. Ver pedidos em aberto");
            System.out.println("6. Sair");
            System.out.print("Escolha a opção desejada: ");


            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    obj.cadastrarPessoa();
                    break;
                case 2:
                    obj.exibirPessoas(obj.pessoas);
                    break;
                case 3:
                    obj.exibirMenu();
                    break;
                case 4:
                    obj.realizarPedido();
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
            }
        }while (opcao!=5);
    }
}
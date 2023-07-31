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
        limparTerminal();
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
    public void pesquisarPessoaPorNome(List<Pessoa> pessoas, String nomePesquisado) {
        boolean encontrou = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePesquisado)) {
                encontrou = true;
                System.out.println("Pessoa encontrada:");
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println("Endereços:");

                List<Endereco> enderecos = pessoa.getEnderecos();
                for (Endereco endereco : enderecos) {
                    System.out.println("Rua: " + endereco.getRua());
                    System.out.println("Número: " + endereco.getNumero());
                    System.out.println();
                }
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Pessoa não encontrada.");
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            if (os.contains("win")) {

                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {

                processBuilder = new ProcessBuilder("sh", "-c", "clear");
            }
            processBuilder.inheritIO().start().waitFor();
        } catch (Exception e) {

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
            System.out.println("2. Exibir informacoes sobre a pessoa");
            System.out.println("3. Exibir menu da pizzaria");
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
                    scanner.nextLine();
                    System.out.println("Digite o nome da pessoa para pesquisar:");
                    String nomePesquisado = scanner.nextLine();
                    obj.pesquisarPessoaPorNome(obj.pessoas, nomePesquisado);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
            }
        }while (opcao!=4);
    }














}
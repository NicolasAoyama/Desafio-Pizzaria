package main;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {


    private String nome;
    private int idade;
    private List<Endereco> enderecos;
    private Pedido pedido;

    public Pessoa(String nome, int idade, List<Endereco> enderecos) {
        this.nome = nome;
        this.idade = idade;
        this.enderecos = enderecos;

    }
    public Pessoa(String nome, int idade, List<Endereco> enderecos, Pedido pedido) {
        this.nome = nome;
        this.idade = idade;
        this.enderecos = enderecos;
        this.pedido = pedido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }











}

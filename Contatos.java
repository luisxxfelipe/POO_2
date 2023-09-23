package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Contatos {
    private String nome;
    private String endereco;
    private String email;

    public Contatos() {

    }

    public Contatos(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimirDados() {
        System.out.println("\n***DADOS DO CONTATO***\n");
        System.out.println(toString());
        System.out.println();
    }

    @Override
    public String toString() {
        String ret;
        ret = "Nome: " + getNome() + "\n";
        ret += "E-mail: " + getEmail() + "\n";
        ret += "Endereco: " + getEndereco() + "\n";

        return ret;
    }
}
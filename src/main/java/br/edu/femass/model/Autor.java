package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String nome;
    private String sobreNome;
    private String nacionalidade;

    private List<Livro> livros;

    public Autor(String nome, String sobreNome, String nacionalidade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nacionalidade = nacionalidade;
        this.livros = new ArrayList<Livro>();
    }

    public Autor() {

    }


    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String nomeEsobrenome() {
        return this.nome + " " + this.sobreNome;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobreNome;
    }

}
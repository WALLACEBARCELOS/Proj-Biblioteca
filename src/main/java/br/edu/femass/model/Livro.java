package br.edu.femass.model;

import java.util.List;

public class Livro {



    private Long codigo;
    private String titulo;
    private Autor autor;
    private String ano;
    private static Long proximoNumero = 1L;

    private List<Exemplar> exemplares;


    public Livro(String titulo, Autor autor, String ano){
        this.codigo = proximoNumero;
        proximoNumero ++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public Livro (){

    }

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAno() {
        return ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return ("Codigo: " + this.codigo + " - " + " Titulo: " + this.titulo + " - " + " Autor: " + this.autor + " - " +" Ano: " + this.ano);
    }


    public static void atualizarProximoNumero(List<Livro> livros) {
        for (Livro livro : livros) {
            if (livro.getCodigo() > proximoNumero) {
                proximoNumero = livro.getCodigo() + 1;
            }
        }
    }


}

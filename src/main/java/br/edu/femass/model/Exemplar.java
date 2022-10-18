package br.edu.femass.model;

import java.time.LocalDateTime;
import java.util.List;

public class Exemplar {

    private Long codigo;
    private LocalDateTime dataAquisicao;

    private String titulo;
    private Livro livro;
    private static Long proximoNumero = 1L;

    public Exemplar(Livro livro) {
        this.codigo = proximoNumero;
        proximoNumero ++;
        this.dataAquisicao = LocalDateTime.now();
        this.titulo = livro.getTitulo();

    }


    public Exemplar() {

    }
    //List<Exemplar> exemplares = livro.getExemplares();

    public Long getCodigo() {
        return codigo;
    }


    public LocalDateTime getDataAquisicao() {
        return dataAquisicao;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setDataAquisicao(LocalDateTime dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public static void atualizarProximoNumeroE(List<Exemplar> exemplares) {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getCodigo() > proximoNumero) {
                proximoNumero = exemplar.getCodigo() + 1;
            }
        }
    }

    @Override
    public String toString() {
        return (this.codigo + " - " + this.titulo);
    }


}

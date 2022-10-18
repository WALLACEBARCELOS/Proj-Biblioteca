package br.edu.femass.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private Exemplar exemplar;
    private Leitor leitor;
    public List<Leitor> atrasado = new ArrayList<>();

    public Emprestimo() {

    }

    public Emprestimo(Exemplar exemplar, Leitor leitor){
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        this.dataEmprestimo = LocalDate.now();
        this.exemplar = exemplar;
        this.leitor = leitor;

    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    //verifica se a data e anterior a data especificada
    public boolean atraso(){
        return this.getDataPrevistaDevolucao().isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return this.getExemplar() + "  -  " + "Devolução MAX: " + this.getDataPrevistaDevolucao().toString();
    }

}

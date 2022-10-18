package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Leitor {

    protected Long codigo;
    protected Long proximoCodigo = 1L;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected Integer prazoMaximoDevolucao;

    public List<Leitor> leitores = new ArrayList<>();


    public Leitor (){

    }
    public Leitor (String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigo = proximoCodigo;
        proximoCodigo = proximoCodigo +1;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPrazoMaximoDevolucao(Integer prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }
    public boolean equals(Object obj){
        Leitor leitor = (Leitor) obj;
        if(leitor ==null)return false;
        return this.prazoMaximoDevolucao.equals(leitor.getPrazoMaximoDevolucao());
    }

    @Override
    public String toString() {
        return getCodigo() +"-"+ getNome();
    }


    public void LeitorAtrasado(Emprestimo emprestimo){
        if(emprestimo.atraso()==true){
            List<Leitor> atrasado = new ArrayList<>();
            atrasado.add(this);
        }
    }
}



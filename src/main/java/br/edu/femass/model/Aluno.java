package br.edu.femass.model;


public class Aluno extends Leitor{

    private String matricula;

    public Aluno(){

    }
    public Aluno (String matricula, String nome, String endereco, String telefone){
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.prazoMaximoDevolucao = 15;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.endereco + " - " + this.telefone;
    }
}

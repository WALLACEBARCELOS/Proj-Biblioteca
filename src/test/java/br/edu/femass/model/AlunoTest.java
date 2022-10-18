package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void testCostrutorVazio(){
        Aluno aluno = new Aluno();
        String esperado = ("null - null - null - null");
        Assertions.assertEquals(esperado, aluno.toString());
    }
    @Test
    void testCostrutorComParametros(){
        Aluno aluno = new Aluno("2020","wallace","macae","22999655402");
        String esperadoNome = "wallace";
        String esperadoMatricula = "2020";
        String esperadoEndereco = "macae";
        String esperadoTelefone = "22999655402";
        Assertions.assertEquals(esperadoNome, "wallace");
        Assertions.assertEquals(esperadoMatricula, "2020");
        Assertions.assertEquals(esperadoEndereco, "macae");
        Assertions.assertEquals(esperadoTelefone, "22999655402");
    }



    @Test
    void testToString() {
        Aluno aluno = new Aluno ("2020","wallace","macae","22999655402");

        String esperado = "2020 - wallace - macae - 22999655402";

        Assertions.assertEquals(esperado,aluno.toString());
    }
}
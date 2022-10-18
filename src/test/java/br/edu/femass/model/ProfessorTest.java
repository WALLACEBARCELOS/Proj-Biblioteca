package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void testCostrutorVazio(){
        Professor professor = new Professor();
        String esperado = ("null - null - null - null");
        Assertions.assertEquals(esperado, professor.toString());
    }
    @Test
    void testCostrutorComParametros(){
        Professor professor = new Professor("prog","wallace","macae","22999655402");
        String esperadoNome = "wallace";
        String esperadoDiciplina = "prog";
        String esperadoEndereco = "macae";
        String esperadoTelefone = "22999655402";
        Assertions.assertEquals(esperadoNome, "wallace");
        Assertions.assertEquals(esperadoDiciplina, "prog");
        Assertions.assertEquals(esperadoEndereco, "macae");
        Assertions.assertEquals(esperadoTelefone, "22999655402");
    }



    @Test
    void testToString() {
        Professor professor = new Professor ("prog","wallace","macae","22999655402");

        String esperado = "prog - wallace - macae - 22999655402";

        Assertions.assertEquals(esperado,professor.toString());
    }
}
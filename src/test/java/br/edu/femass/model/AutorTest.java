package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    void testCostrutorVazio(){
        Autor autor = new Autor();
        String esperado = ("null");
        Assertions.assertEquals(esperado, "null");
    }
    @Test
    void testCostrutorComParametros(){
        Autor autor = new Autor("wallace","sobrenome","nascionalidade");
        String esperadoNome = "wallace";
        String esperadoSobrenome = "sobrenome";
        String esperadoNascionalidade = "nascionalidade";
        Assertions.assertEquals(esperadoNome, "wallace");
        Assertions.assertEquals(esperadoSobrenome, "sobrenome");
        Assertions.assertEquals(esperadoNascionalidade, "nascionalidade");

    }

    @Test
    void nomeEsobrenome() {
        Autor autor = new Autor();
        String esperado = autor.getNome() + " " + autor.getSobreNome();
        Assertions.assertEquals(esperado, autor.nomeEsobrenome());
    }

    @Test
    void testToString() {
        Autor autor = new Autor("wallace","sobrenome","nascionalidade");
        String esperado = "wallace sobrenome";
        Assertions.assertEquals(esperado, autor.toString());

    }
}
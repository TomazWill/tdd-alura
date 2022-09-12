package br.com.alura.tdd;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumerosPositivos(){
        Calculadora calculadora = new Calculadora();
        int soma = calculadora.somar(3, 7);
        Assertions.assertEquals(10, soma);
        // Ao passar valor não esperado, o não passa no teste
        // Assertions.assertEquals(12, soma);
    }


}
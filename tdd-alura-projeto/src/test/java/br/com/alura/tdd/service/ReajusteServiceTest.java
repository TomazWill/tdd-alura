package br.com.alura.tdd.service;


import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

//    @BeforeAll // Executa uma ação uma única vez antes dos testes.
//    public static void antesDeTodos() {
//        System.out.printIn("ANTES DE TODOS");
//    }
//    @AfterAll // Executa uma ação uma única vez depois dos testes.
//    public static void depoisDeTodos() {
//        System.out.printIn("DEPOIS DE TODOS");
//    }

    // @AfterEach  => JUnit depois de cada um dos métodos execute o método: 'metodoFinalExemplo()'...
    // @BeforeEach => JUnit antes de cada um dos métodos execute esse método abaixo:
    @BeforeEach
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void ReajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void ReajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void ReajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}

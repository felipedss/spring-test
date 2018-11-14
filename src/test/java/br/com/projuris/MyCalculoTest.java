package br.com.projuris;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MyCalculoTest {

    private Funcionario joao = new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0));
    private Funcionario pedro = new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70));
    private Funcionario paulo = new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45));
    private Funcionario marcos = new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9));
    private Funcionario felipe = new Funcionario("Gerente", "Financeiro", new BigDecimal(7500));
    private Funcionario rubens = new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0));
    private Funcionario carlos = new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4));
    private Funcionario rafael = new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90));
    private Funcionario tobias = new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50));
    private Funcionario fred = new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0));

    private List<Funcionario> listaFuncionario = Arrays.asList(joao, pedro, paulo, marcos, felipe, rubens, carlos, rafael, tobias, fred);

    private MyCalculo myCalculo = new MyCalculo();

    private static final Map<String, BigDecimal> custoPorCargo = new HashMap<String, BigDecimal>() {
        {
            put("Assistente", new BigDecimal(4101.8));
            put("Gerente", new BigDecimal(24001.2));
            put("Diretor", new BigDecimal(34000.45));
            put("Estagiário", new BigDecimal(700.4));
        }
    };

    private static final Map<String, BigDecimal> custoPorDepartamento = new HashMap<String, BigDecimal>() {
        {
            put("Administrativo", new BigDecimal(18001.15));
            put("Financeiro", new BigDecimal(19800.9));
            put("Jurídico", new BigDecimal(25001.8));
        }
    };


    @Test
    public void deveValidarTotalSalarialPorCargo() {

        final List<CustoCargo> custoCargos = myCalculo.custoPorCargo(listaFuncionario);

        custoCargos.forEach(item -> {
            final BigDecimal custoEsperado = setRound(custoPorCargo.get(item.getDescricao()));
            final BigDecimal custoCalculado = setRound(item.getCusto());
            assertEquals(custoEsperado, custoCalculado);
        });

    }

    @Test
    public void deveValidarTotalSalarialPorDepartamento() {

        final List<CustoDepartamento> custoDepartamentos = myCalculo.custoPorDepartamento(listaFuncionario);

        custoDepartamentos.forEach(item -> {
            final BigDecimal custoEsperado = setRound(custoPorDepartamento.get(item.getDescricao()));
            final BigDecimal custoCalculado = setRound(item.getCusto());
            assertEquals(custoEsperado, custoCalculado);
        });

    }

    private BigDecimal setRound(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }

}

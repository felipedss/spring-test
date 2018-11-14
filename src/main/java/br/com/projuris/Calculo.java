package br.com.projuris;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Calculo {

    default Map<String, BigDecimal> groupBy(List<Funcionario> funcionarios, Function<Funcionario, String> functionToGroup) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(functionToGroup,
                        Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)));
    }

    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios);

    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios);
}

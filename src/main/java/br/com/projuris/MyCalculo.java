package br.com.projuris;

import java.util.List;
import java.util.stream.Collectors;

public class MyCalculo implements Calculo {


    @Override
    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
        return groupBy(funcionarios, Funcionario::getCargo)
                .entrySet()
                .stream()
                .map(item -> new CustoCargo(item.getKey(), item.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
        return groupBy(funcionarios, Funcionario::getDepartamento)
                .entrySet()
                .stream()
                .map(item -> new CustoDepartamento(item.getKey(), item.getValue()))
                .collect(Collectors.toList());
    }

}

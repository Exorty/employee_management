package com.miller.gerenciamentoFuncionarios.services;

import java.util.List;

import com.miller.gerenciamentoFuncionarios.models.Funcionario;

public interface FuncionarioService {

    List<Funcionario> findAll();
    Funcionario findById(Long id);
    Funcionario save(Funcionario funcionario);
    void deleteById(long id);
	
    
}
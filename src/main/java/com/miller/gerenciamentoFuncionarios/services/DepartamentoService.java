package com.miller.gerenciamentoFuncionarios.services;

import java.util.List;

import com.miller.gerenciamentoFuncionarios.models.Departamento;

public interface DepartamentoService {
    List<Departamento> findAll();
    Departamento save(Departamento departamento);
    void deleteById(long id);
	Departamento findById(Long id);
    
}
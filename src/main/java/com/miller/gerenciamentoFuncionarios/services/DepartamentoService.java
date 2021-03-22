package com.miller.gerenciamentoFuncionarios.services;

import java.util.List;

import com.miller.gerenciamentoFuncionarios.models.Departamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartamentoService {
    
    List<Departamento> findAll();
    Page<Departamento> listAll(Pageable pageable, String keyword);
    Departamento save(Departamento departamento);
    void deleteById(long id);
	Departamento findById(Long id);
    
}
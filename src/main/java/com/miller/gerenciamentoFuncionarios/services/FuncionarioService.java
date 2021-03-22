package com.miller.gerenciamentoFuncionarios.services;

import java.util.List;

import com.miller.gerenciamentoFuncionarios.models.Funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncionarioService {

    List<Funcionario> findAll();
    Page<Funcionario> listAll(Pageable pageable, String keyword);
    Funcionario findById(Long id);
    Funcionario save(Funcionario funcionario);
    void deleteById(long id);
	
    
}
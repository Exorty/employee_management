package com.miller.gerenciamentoFuncionarios.repositories;



import com.miller.gerenciamentoFuncionarios.models.Funcionario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
    
    Page<Funcionario> findAll(Pageable pageable);

}
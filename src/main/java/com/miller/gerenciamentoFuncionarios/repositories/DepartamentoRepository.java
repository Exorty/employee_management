package com.miller.gerenciamentoFuncionarios.repositories;

import com.miller.gerenciamentoFuncionarios.models.Departamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
    Page<Departamento> findAll(Pageable pageable);
}
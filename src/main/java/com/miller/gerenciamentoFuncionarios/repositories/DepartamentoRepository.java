package com.miller.gerenciamentoFuncionarios.repositories;

import com.miller.gerenciamentoFuncionarios.models.Departamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
    Page<Departamento> findAll(Pageable pageable);

    @Query("SELECT d FROM Departamento d WHERE CONCAT(d.id, ' ',d.nome) LIKE %?1%")
    Page<Departamento> findAll(Pageable pageable, String keyword);
}
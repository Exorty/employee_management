package com.miller.gerenciamentoFuncionarios.repositories;

import com.miller.gerenciamentoFuncionarios.appuser.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long>{

    public AppUser findByUsername(String username);
    
}
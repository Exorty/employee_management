package com.miller.gerenciamentoFuncionarios.services.serviceImpl;

import java.util.List;

import com.miller.gerenciamentoFuncionarios.models.Funcionario;
import com.miller.gerenciamentoFuncionarios.repositories.FuncionarioRepository;
import com.miller.gerenciamentoFuncionarios.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {

        return funcionarioRepository.findAll(Sort.by("id"));
    }




    @Override
    public Funcionario save(Funcionario funcionario) {

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteById(long id) {
        funcionarioRepository.deleteById(id);

    }

    @Override
    public Funcionario findById(Long id) {

        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Page<Funcionario> listAll(Pageable pageable, String keyword) {
         
        if (keyword != null) {
            return funcionarioRepository.findAll(pageable, keyword);
        }
        
        return funcionarioRepository.findAll(pageable);
    }

  


 
}
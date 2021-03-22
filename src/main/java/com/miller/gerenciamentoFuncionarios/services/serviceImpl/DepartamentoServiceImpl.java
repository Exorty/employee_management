package com.miller.gerenciamentoFuncionarios.services.serviceImpl;

import java.util.List;

import com.miller.gerenciamentoFuncionarios.models.Departamento;
import com.miller.gerenciamentoFuncionarios.repositories.DepartamentoRepository;
import com.miller.gerenciamentoFuncionarios.services.DepartamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> findAll() {

        return departamentoRepository.findAll(Sort.by("id"));
    }

    @Override
    public Departamento save(Departamento departamento) {

        return departamentoRepository.save(departamento);
    }

    @Override
    public void deleteById(long id) {
        departamentoRepository.deleteById(id);

    }

    @Override
    public Departamento findById(Long id) {

        return departamentoRepository.findById(id).get();
    }

    @Override
    public Page<Departamento> listAll(Pageable pageable, String keyword) {
       
        if (keyword != null) {
            return departamentoRepository.findAll(pageable, keyword);
        }
        
        return departamentoRepository.findAll(pageable);
    }
    
}
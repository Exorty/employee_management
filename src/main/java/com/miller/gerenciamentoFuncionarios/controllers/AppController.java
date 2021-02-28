package com.miller.gerenciamentoFuncionarios.controllers;

import java.util.List;

import javax.validation.Valid;

import com.miller.gerenciamentoFuncionarios.models.Departamento;
import com.miller.gerenciamentoFuncionarios.models.Funcionario;
import com.miller.gerenciamentoFuncionarios.repositories.DepartamentoRepository;
import com.miller.gerenciamentoFuncionarios.repositories.FuncionarioRepository;
import com.miller.gerenciamentoFuncionarios.services.DepartamentoService;
import com.miller.gerenciamentoFuncionarios.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/painel")
    public String index() {
        return "index";

    } 

    @GetMapping("/login")
    public String login() {
        
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }


    @GetMapping("/lista/funcionarios/{page}")
    public String getFuncionarios(@PathVariable("page") Integer page, Funcionario f, Model model, String keyword) {
     
        List<Departamento> departamentos = departamentoService.findAll();
       Pageable pageable = PageRequest.of(page, 5);
       Page<Funcionario> funcionariosPage = funcionarioRepository.findAll(pageable);
         model.addAttribute("funcionariosPage", funcionariosPage);
         model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", funcionariosPage.getTotalPages());
  
        model.addAttribute("f", f);
        model.addAttribute("departamentos", departamentos);
        return "funcionarios";

    }

    @PostMapping("/lista/funcionarios")
    public String saveFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
         
            attributes.addFlashAttribute("funcionario", funcionario);
            return "redirect:/lista/funcionarios/0";

        }

        funcionarioRepository.save(funcionario);

        return "redirect:/lista/funcionarios/0";
    }

    @GetMapping("/lista/editarFuncionario/{id}")
    public String editFuncionario(@PathVariable("id") Long id, Model model) {

        Funcionario funcionario = funcionarioService.findById(id);
        List<Departamento> departamentos = departamentoService.findAll();
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("departamentos", departamentos);

        return "editarFuncionario";
    }

    @PostMapping("/lista/editarFuncionario")
    public String saveEditFuncionario(@Valid Funcionario funcionario,BindingResult result, Model model, 
            RedirectAttributes attributes) {

        if (result.hasErrors()) {
          
      
            return "redirect:/lista/editarFuncionario/" + funcionario.getId();

        }

       
        funcionarioRepository.save(funcionario);

     return "redirect:/lista/funcionarios/0";
    }

    @GetMapping("/lista/departamentos/{page}")
    public String getDepartamentos(@PathVariable("page") Integer page, Departamento d, Model model) {

        Pageable pageable = PageRequest.of(page, 5);
        Page<Departamento> departamentoPage = departamentoRepository.findAll(pageable);
          model.addAttribute("departamentosPage", departamentoPage);
          model.addAttribute("currentPage", page);
         model.addAttribute("totalPages", departamentoPage.getTotalPages());
         

        List<Departamento> departamentos = departamentoService.findAll();
        model.addAttribute("departamentos", departamentos);
        model.addAttribute("d", d);

        return "departamentos";

    }

    @PostMapping("/lista/departamentos")
    public String saveDepartamento(Departamento departamento, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            
            attributes.addFlashAttribute("departamento", departamento);
            return "redirect:/lista/departamentos/0";

        }

        departamentoService.save(departamento);

        return "redirect:/lista/departamentos/0";
    }

    @GetMapping("/lista/editarDepartamento/{id}")
    public String editDepartamento(@PathVariable("id") Long id, Model model) {

       
        List<Departamento> departamentos = departamentoService.findAll();
       Departamento departamento = departamentoService.findById(id);
        model.addAttribute("departamentos", departamentos);
        model.addAttribute("departamento", departamento);

        return "editarDepartamento";
    }

    @PostMapping("/lista/editarDepartamentos")
    public String saveEditDepartamento(@Valid Departamento departamento, BindingResult result,
            RedirectAttributes attributes) {

        if (result.hasErrors()) {
            
            attributes.addFlashAttribute("departamento", departamento);
            return "redirect:/lista/editarDepartamento/" + departamento.getId();

        }

        departamentoService.save(departamento);

        return "redirect:/lista/departamentos/0";
    }

    @GetMapping("/funcionario/delete/{id}")
    public String deleteFuncionario(@PathVariable("id") Long id) {

        funcionarioService.deleteById(id);

        return "redirect:/lista/funcionarios/0";
    }

    @GetMapping("/departamento/delete/{id}")
    public String deleteDepartamento(@PathVariable("id") Long id) {

        departamentoService.deleteById(id);

        return "redirect:/lista/departamentos/0";
    }

    

   

}
package com.miller.gerenciamentoFuncionarios.appuser;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;





@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Usuário não pode ser vazio")
    @Column(name = "username", unique = true ,nullable = false, length = 20)
    private String username;

    @NotBlank(message = "Senha não pode ser vazia")
    @Column(nullable = false, length = 64)
    private String password;

    private Boolean enabled;



    public AppUser() {
    }

  
    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    


    

    public void setPassword(String password) {
        this.password = password;
    }

   
    public String getPassword() {
   
        return password;
    }


    
    public String getUsername() {
 
        return username;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "AppUser [enabled=" + enabled + ", id=" + id + ", password=" + password + ", username=" + username + "]";
    }

  

  





   

    
}
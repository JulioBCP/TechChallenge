package com.fiap.techchallenge.carrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Embeddable
public class Usuario {
   
   @Column(nullable = false)
   private String usuario;

   @Column(nullable = false)
   private String senha;

   @Column(nullable = false)
   private String nome;

   @Enumerated(EnumType.STRING)
   private TipoUsuarioEnum tipoUsuario;

}

package com.fiap.techchallenge.carrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Embeddable
public class Usuario {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false)
   private String usuario;

   @Column(nullable = false)
   private String senha;

   @Column(nullable = false)
   private String nome;

   @Enumerated(EnumType.STRING)
   private TipoUsuarioEnum tipoUsuario;

}

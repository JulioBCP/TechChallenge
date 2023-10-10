package com.fiap.techchallenge.carrental.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

   private int id;
   private String usuario;
   private String senha;
   private String nome;
   private TipoUsuarioEnum tipoUsuario;

}

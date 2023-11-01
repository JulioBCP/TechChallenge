package com.fiap.techchallenge.carrental.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.techchallenge.carrental.cliente.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 

}
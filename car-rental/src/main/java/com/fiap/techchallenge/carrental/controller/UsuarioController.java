package com.fiap.techchallenge.carrental.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiap.techchallenge.carrental.DTO.AtualizaUsuarioDTO;
import com.fiap.techchallenge.carrental.entity.Usuario;
import com.fiap.techchallenge.carrental.service.CadastroUsuarioService;

@RestController
@RequestMapping(value="/Usuarios")
public class UsuarioController {
    
    @Autowired
    CadastroUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario Usuario, UriComponentsBuilder builder) {
        usuarioService.inserirUsuario(Usuario);
        
        URI location = builder.path("Usuarios/{usuario}").buildAndExpand(Usuario.getUsuario()).toUri();        
        return ResponseEntity.created(location).body(Usuario);       
    }

    @GetMapping("/{usuario}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable long usuario) {
        return ResponseEntity.ok().body(usuarioService.encontrarUsuario(usuario));
    }

    @PutMapping("/{usuario}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable long usuario, @RequestBody AtualizaUsuarioDTO dto) {
        return ResponseEntity.ok().body(usuarioService.alterarUsuario(dto, usuario));
    }

    @DeleteMapping("/{usuario}")
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable long usuario) {
        return ResponseEntity.noContent().build();
    }
}
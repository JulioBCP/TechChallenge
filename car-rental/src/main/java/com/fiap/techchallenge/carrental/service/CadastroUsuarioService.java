package com.fiap.techchallenge.carrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techchallenge.carrental.DTO.AtualizaUsuarioDTO;
import com.fiap.techchallenge.carrental.entity.Usuario;
import com.fiap.techchallenge.carrental.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //creat
    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //read
    public Usuario encontrarUsuario(Long id) {
        return usuarioRepository.getReferenceById(id);
    } 

    //update
    public Usuario alterarUsuario(AtualizaUsuarioDTO atualizaUsuario, long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setSenha(atualizaUsuario.senha());
        usuario.setLogin(atualizaUsuario.login());

        return usuarioRepository.save(usuario);
    }

    //delete
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
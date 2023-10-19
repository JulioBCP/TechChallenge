package com.fiap.techchallenge.carrental.DTO;

import com.fiap.techchallenge.carrental.entity.TipoUsuarioEnum;

public record AtualizaUsuarioDTO(String senha, TipoUsuarioEnum tipoUsuario) {
    
}

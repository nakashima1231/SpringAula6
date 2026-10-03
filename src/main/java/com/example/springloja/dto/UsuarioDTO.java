package com.example.springloja.dto;

import com.example.springloja.entities.Usuario;

public record UsuarioDTO(long id, String username, String role) {

    public UsuarioDTO(Usuario user) {
        this(user.getId(), user.getUsername(), user.getRole());
    }
}

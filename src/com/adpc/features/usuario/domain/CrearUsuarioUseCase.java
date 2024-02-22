package com.adpc.features.usuario.domain;

import java.io.File;
import java.io.IOException;


public class CrearUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void crearUsuario(String nombre) {
        Usuario usuario = new Usuario(nombre);
        usuarioRepository.guardarUsuario(usuario);
    }
}

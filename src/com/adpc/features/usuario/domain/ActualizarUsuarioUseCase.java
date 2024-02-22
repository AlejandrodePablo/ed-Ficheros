package com.adpc.features.usuario.domain;


import java.io.File;


public class ActualizarUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public ActualizarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.guardarUsuario(usuario);
    }
}

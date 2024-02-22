package com.adpc.features.usuario.domain;

public interface UsuarioRepository {

    /*
    void execute (Usuario nombre);
    void update(Usuario nombre);
    String ARCHIVO_CONFIGURACION = "config.txt";
     */
    void guardarUsuario(Usuario usuario);
    Usuario obtenerUsuario();
}


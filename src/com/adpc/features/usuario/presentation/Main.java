package com.adpc.features.usuario.presentation;

import com.adpc.features.usuario.data.UsuarioDataRepository;
import com.adpc.features.usuario.domain.ActualizarUsuarioUseCase;
import com.adpc.features.usuario.domain.CrearUsuarioUseCase;
import com.adpc.features.usuario.domain.Usuario;
import com.adpc.features.usuario.domain.UsuarioRepository;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioDataRepository();
        CrearUsuarioUseCase crearUsuarioUseCase = new CrearUsuarioUseCase(usuarioRepository);
        ActualizarUsuarioUseCase actualizarUsuarioUseCase = new ActualizarUsuarioUseCase(usuarioRepository);

        Scanner scanner = new Scanner(System.in);

        if (usuarioRepository.obtenerUsuario() == null) {
            System.out.println("Primera vez");
            System.out.print("Introduce tu nombre: ");
            String nombre = scanner.nextLine();
            crearUsuarioUseCase.crearUsuario(nombre);
        } else {
            System.out.println("No es la primera vez");
            System.out.print("Introduce tu nombre: ");
            String nombre = scanner.nextLine();
            actualizarUsuarioUseCase.actualizarUsuario(new Usuario(nombre));
        }
    }
}


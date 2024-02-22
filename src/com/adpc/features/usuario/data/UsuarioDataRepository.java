package com.adpc.features.usuario.data;

import com.adpc.features.usuario.domain.Usuario;
import com.adpc.features.usuario.domain.UsuarioRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsuarioDataRepository implements UsuarioRepository {


    private static final String FILE_PATH = "usuarios.txt";

    public UsuarioDataRepository() {
        if (!Files.exists(Paths.get(FILE_PATH))) {
            try {
                Files.createFile(Paths.get(FILE_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void guardarUsuario(Usuario usuario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(usuario.getNombre())) {
                    return; // El usuario ya existe, no lo guardamos de nuevo
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println(usuario.getNombre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String nombre = reader.readLine();
            if (nombre != null) {
                return new Usuario(nombre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}





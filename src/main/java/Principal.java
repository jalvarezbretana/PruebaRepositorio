import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        //Pido el usuario por teclado
        String usuario = JOptionPane.showInputDialog("Introduce el usuario");
        //Pido la contraseña
        String contraseña = JOptionPane.showInputDialog("Introduce la contraseña");
        //Pido el nombre del repositorio que voy a crear
        String nombreRepo = JOptionPane.showInputDialog("Introduce el nombre del repositorio");
        //Pido la descripcion del repositorio
        String descRepo = JOptionPane.showInputDialog("Introduce la descripcion");
        //Metodo para crear el repositorio con usuario y contraseña
        GitHub github = new GitHubBuilder().withPassword(usuario, contraseña).build();
        GHRepository repo = github.createRepository(nombreRepo, descRepo,
                "https://www.google.com/", false);
        //Añado a Damian a los colaboradores
        repo.addCollaborators(github.getUser("damiancastelao"));
    }
}




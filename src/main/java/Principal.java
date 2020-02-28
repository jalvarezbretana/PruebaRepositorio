import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        //Pido el token para poder crear el repositorio
        String token = JOptionPane.showInputDialog("Introduce el token");
        //Pido el nombre del repositorio que voy a crear
        String nombreRepo = JOptionPane.showInputDialog("Introduce el nombre del repositorio");
        //Pido la descripcion del repositorio
        String descRepo = JOptionPane.showInputDialog("Introduce la descripcion");
        //Metodo para crear el repositorio usando un token
        GitHub github = new GitHubBuilder().withJwtToken(token).build();
        GHRepository repo = github.createRepository(nombreRepo,descRepo,
                "https://www.google.com/",false);
        //Añado a damian a los colaboradores
        repo.addCollaborators(github.getUser("damiancastelao"));
    }
}




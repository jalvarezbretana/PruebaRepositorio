import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, GitAPIException {
        //Pido el nombre del repositorio que voy a crear
        String nombreRepo = JOptionPane.showInputDialog("Introduce el nombre del repositorio");
        //Pido la descripcion del repositorio
        String descRepo = JOptionPane.showInputDialog("Introduce la descripcion");
        //Metodo para crear el repositorio usando el archivo property (.github)
        GitHub github = GitHubBuilder.fromPropertyFile("/home/local/DANIELCASTELAO/jalvarezbretana/IdeaProjects/Github/.github").build();
        GHRepository repo = github.createRepository(nombreRepo,descRepo,
                "https://www.google.com/",false);

        //
        Git git = Git.cloneRepository()
                .setURI( "https://github.com/eclipse/jgit.git" )
                .setDirectory(new File("https://github.com/jalvarezbretana/basico-master.git"))
                .call();

        //Añado a damian a los colaboradores
        repo.addCollaborators(github.getUser("damiancastelao"));
    }
}




package course.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 */
@Mojo(name = "touch", defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class MyMojo extends AbstractMojo {
    /**
     * Directory of the file.
     */
	@Parameter(required = true, defaultValue = "${project.build.directory}")
    private File outputDirectory;

    public void execute() throws MojoExecutionException {

        if (!outputDirectory.exists()) {
        	outputDirectory.mkdirs();
        }

        final File touch = new File(outputDirectory, "touch.txt");

        try (final FileWriter w = new FileWriter(touch)) {
            w.write("touch.txt");
            getLog().info("Created file " + touch);
        } catch (final IOException e) {
            throw new MojoExecutionException("Error creating file " + touch, e);
        }
    }
}

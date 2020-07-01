package ml.sadriev.orm.command.project;

import java.util.Scanner;
import javax.annotation.Resource;
import ml.sadriev.orm.api.service.IProjectService;
import ml.sadriev.orm.command.AbstractCommand;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public final class ProjectRemoveCommand extends AbstractCommand {

    @Resource
    private IProjectService projectService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVING PROJECT]");
        System.out.println("Enter project name:");

        String name = "";
        name = scanner.nextLine();

        projectService.removeProjectByName(name);
        System.out.println("[OK]");
    }
}

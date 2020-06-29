package ml.sadriev.orm.command.project;

import javax.annotation.Resource;
import ml.sadriev.orm.service.ProjectService;
import org.springframework.stereotype.Component;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectListCommand extends AbstractCommand {

    @Resource
    private ProjectService projectService;

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "Show all projects.";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT LIST]");
        int index = 1;
        for (Project project: projectService.getListProject()) {
            System.out.println(index++ + ". " + project.getName());
        }
        System.out.println();
    }

}

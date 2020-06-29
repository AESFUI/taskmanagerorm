package ml.sadriev.orm.command.project;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.service.ProjectService;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectClearCommand extends AbstractCommand {

    @Resource
    private ProjectService projectService;

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    public void execute() {
        projectService.clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}

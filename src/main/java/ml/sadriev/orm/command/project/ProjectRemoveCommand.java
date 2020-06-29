package ml.sadriev.orm.command.project;

import org.springframework.stereotype.Component;
import ml.sadriev.orm.command.AbstractCommand;

/**
 * @author Andrey Sadriev
 */
@Component
public final class ProjectRemoveCommand extends AbstractCommand {

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
    }
}

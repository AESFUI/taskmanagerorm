package ml.sadriev.orm.command.task;

import javax.annotation.Resource;
import ml.sadriev.orm.api.service.ITaskService;
import org.springframework.stereotype.Component;
import ml.sadriev.orm.command.AbstractCommand;

/**
 * @author Andrey Sadriev
 */
@Component
public final class TaskClearCommand extends AbstractCommand {

    @Resource
    private ITaskService taskService;

    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Override
    public void execute() {
        taskService.clear();
        System.out.println("[ALL TASK REMOVED]");
    }

}

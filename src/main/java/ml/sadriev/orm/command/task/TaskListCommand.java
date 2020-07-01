package ml.sadriev.orm.command.task;

import javax.annotation.Resource;
import ml.sadriev.orm.api.service.ITaskService;
import org.springframework.stereotype.Component;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.model.Task;

/**
 * @author Andrey Sadriev
 */
@Component
public final class TaskListCommand extends AbstractCommand {

    @Resource
    private ITaskService taskService;

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        int index = 1;
/*        for (Task task : taskService.getListTask()) {
            System.out.println(index + ". " + task.getName());
            index++;
        }*/
        System.out.println();
    }

}

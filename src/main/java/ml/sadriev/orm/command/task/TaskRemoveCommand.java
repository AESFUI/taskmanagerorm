package ml.sadriev.orm.command.task;

import java.util.Scanner;
import javax.annotation.Resource;
import ml.sadriev.orm.api.service.ITaskService;
import org.springframework.stereotype.Component;
import ml.sadriev.orm.command.AbstractCommand;

/**
 * @author Andrey Sadriev
 */
@Component
public final class TaskRemoveCommand extends AbstractCommand {

    @Resource
    private ITaskService taskService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVING TASK]");
        System.out.println("Enter task name:");

        String name = "";
        name = scanner.nextLine();

        if (taskService.removeTaskByName(name) == 1) {
            System.out.println("[OK]");
        } else {
            System.out.println("[Error. Task not deleted.]");
        }
    }
}

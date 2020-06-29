package ml.sadriev.orm.command.data.bin;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.annotation.Resource;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.constant.DataConstant;
import ml.sadriev.orm.service.ProjectService;
import ml.sadriev.orm.service.TaskService;
import org.springframework.stereotype.Component;
import ml.sadriev.orm.entity.Project;
import ml.sadriev.orm.entity.Task;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataBinaryLoadCommand extends AbstractCommand {

    @Resource
    private ProjectService projectService;
    @Resource
    private TaskService taskService;

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "Save data to binary file.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY LOAD]");
        final FileInputStream fileInputStream = new FileInputStream(DataConstant.FILE_BINARY);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        loadProjects(objectInputStream.readObject());
        loadTasks(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("[OK]");
    }

    private void loadProjects(final Object value) {
        if (!(value instanceof Project[])) return;
        final Project[] projects = (Project[]) value;
        projectService.load(projects);
    }

    private void loadTasks(final Object value) {
        if (!(value instanceof Task[])) return;
        final Task[] tasks = (Task[]) value;
        taskService.load(tasks);
    }

}

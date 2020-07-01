package ml.sadriev.orm.command.data.bin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import javax.annotation.Resource;
import ml.sadriev.orm.api.service.IProjectService;
import ml.sadriev.orm.api.service.ITaskService;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.constant.DataConstant;
import ml.sadriev.orm.model.Project;
import ml.sadriev.orm.model.Task;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public final class DataBinarySaveCommand extends AbstractCommand {

    @Resource
    private IProjectService projectService;
    @Resource
    private ITaskService taskService;

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "Load data from binary file.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA BINARY SAVE]");
        final Project[] projects = projectService.getListProject().toArray(new Project[]{});
        final Task[] tasks = taskService.getListTask().toArray(new Task[]{});

        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());

        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("[OK]");
        System.out.println();
    }
}

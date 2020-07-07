package ml.sadriev.orm.api.service;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.model.Task;

/**
 * @author Andrey Sadriev
 */
public interface ITaskService {

    Task createTask(String name);

    Task getTaskById(String id);

    Task merge(Task task);

    int removeTaskByName(String name);

    List<Task> getListTask();

    void clear();

    Task createTaskByProject(String projectId, String taskName);

    Task getByOrderIndex(Integer orderIndex);

    void merge(Task... tasks);

    void load(Task... tasks);

    void load(Collection<Task> tasks);
}

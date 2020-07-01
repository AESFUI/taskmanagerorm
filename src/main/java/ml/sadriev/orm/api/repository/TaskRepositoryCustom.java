package ml.sadriev.orm.api.repository;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.model.Task;

public interface TaskRepositoryCustom {
    Task createTask(String name);

    Task getByOrderIndex(Integer orderIndex);

    void merge(Task... tasks);

    void merge(Collection<Task> tasks);

    void load(Collection<Task> tasks);

    void load(Task... tasks);

    Task merge(Task task);

    void removeTaskById(String id);

    void removeTaskByOrderIndex(Integer orderIndex);

    List<Task> getListTask();

    void clear();
}

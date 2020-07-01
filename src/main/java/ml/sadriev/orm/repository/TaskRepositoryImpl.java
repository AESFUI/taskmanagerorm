package ml.sadriev.orm.repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ml.sadriev.orm.api.repository.TaskRepositoryCustom;
import ml.sadriev.orm.model.Task;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public class TaskRepositoryImpl implements TaskRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<String, Task> map = new LinkedHashMap<>();

    @Override
    public Task createTask(final String name) {
        final Task task = new Task();
        task.setName(name);
        entityManager.merge(task);
        return task;
    }

    @Override
    public void merge(final Task... tasks) {
        for (final Task task: tasks) merge(task);
    }

    @Override
    public void merge(final Collection<Task> tasks) {
        for (final Task task: tasks) merge(task);
    }

    @Override
    public void load(final Collection<Task> tasks) {
        tasks.forEach(entityManager::persist);
    }

    @Override
    public void load(final Task... tasks) {
        Stream.of(tasks).forEach(entityManager::persist);
    }

    @Override
    public Task merge(final Task task) {
        if (task == null) return null;
        entityManager.persist(task);
        return task;
    }
}

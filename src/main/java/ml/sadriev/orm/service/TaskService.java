package ml.sadriev.orm.service;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.api.repository.IProjectRepository;
import ml.sadriev.orm.api.repository.ITaskRepository;
import ml.sadriev.orm.api.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ml.sadriev.orm.entity.Project;
import ml.sadriev.orm.entity.Task;

/**
 * @author Denis Volnenko
 */
@Service
public final class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    private final IProjectRepository projectRepository;

    @Autowired
    public TaskService(
            final ITaskRepository taskRepository,
            final IProjectRepository projectRepository
    ) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.createTask(name);
    }

    @Override
    public Task getTaskById(final String id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public Task merge(final Task task) {
        return taskRepository.merge(task);
    }

    @Override
    public void removeTaskById(final String id) {
        taskRepository.removeTaskById(id);
    }

    @Override
    public List<Task> getListTask() {
        return taskRepository.getListTask();
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }

    @Override
    public Task createTaskByProject(final String projectId, final String taskName) {
        final Project project = projectRepository.getProjectById(projectId);
        if (project == null) return null;
        final Task task = taskRepository.createTask(taskName);
        task.setProjectId(project.getId());
        return task;
    }

    @Override
    public Task getByOrderIndex(Integer orderIndex) {
        return taskRepository.getByOrderIndex(orderIndex);
    }

    @Override
    public void merge(Task... tasks) {
        taskRepository.merge(tasks);
    }

    @Override
    public void load(Task... tasks) {
        taskRepository.load(tasks);
    }

    @Override
    public void load(Collection<Task> tasks) {
        taskRepository.load(tasks);
    }

    @Override
    public void removeTaskByOrderIndex(Integer orderIndex) {
        taskRepository.removeTaskByOrderIndex(orderIndex);
    }

}

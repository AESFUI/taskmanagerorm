package ml.sadriev.orm.service;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.api.repository.ProjectRepository;
import ml.sadriev.orm.api.repository.TaskRepository;
import ml.sadriev.orm.api.service.ITaskService;
import ml.sadriev.orm.model.Project;
import ml.sadriev.orm.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrey Sadriev
 */
@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    private final ProjectRepository projectRepository;

    @Autowired
    public TaskService(final TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public void clear() {
        taskRepository.deleteAll();
    }

    @Override
    @Transactional
    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.createTask(name);
    }

    @Override
    public List<Task> getListTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return taskRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Task merge(final Task task) {
        return taskRepository.merge(task);
    }

    @Override
    @Transactional
    public int removeTaskByName(final String name) {
        return taskRepository.deleteTaskByName(name);
    }

    @Override
    @Transactional
    public Task createTaskByProject(final String projectId, final String taskName) {
        final Project project = projectRepository.findProjectById(projectId);
        if (project == null) return null;
        final Task task = taskRepository.createTask(taskName);
        task.setProjectId(project.getId());
        return task;
    }

    @Override
    public Task getByOrderIndex(Integer orderIndex) {
        return taskRepository.findTaskFirst();
    }

    @Override
    @Transactional
    public void merge(Task... tasks) {
        taskRepository.merge(tasks);
    }

    @Override
    public void load(Task... tasks) {
        clear();
        taskRepository.load(tasks);
    }

    @Override
    public void load(Collection<Task> tasks) {
        clear();
        taskRepository.load(tasks);
    }
}
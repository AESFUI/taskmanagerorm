package ml.sadriev.orm.service;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.api.repository.TaskRepository;
import ml.sadriev.orm.api.repository.TaskRepositoryCustom;
import ml.sadriev.orm.api.service.ITaskService;
import ml.sadriev.orm.model.Project;
import ml.sadriev.orm.model.Task;
import ml.sadriev.orm.repository.ProjectRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrey Sadriev
 */
@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;
    private final TaskRepositoryCustom taskRepositoryCustom;

    private final ProjectRepositoryImpl projectRepository;

    @Autowired
    public TaskService(final TaskRepository taskRepository,
                       final TaskRepositoryCustom taskRepositoryCustom, ProjectRepositoryImpl projectRepositoryImpl) {
        this.taskRepository = taskRepository;
        this.taskRepositoryCustom = taskRepositoryCustom;
        this.projectRepository = projectRepositoryImpl;
    }

    @Transactional
    public void clear() {
        List<Task> taskList = taskRepository.findAll();
        taskRepository.deleteAll(taskList);
    }

    @Transactional
    public Task createTask(final String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepositoryCustom.createTask(name);
    }

/*    @Override
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
    public void removeTaskById(final String id) {
        taskRepository.removeTaskById(id);
    }

    @Override
    public List<Task> getListTask() {
        return taskRepository.getListTask();
    }

    @Override


    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
    public void removeTaskByOrderIndex(Integer orderIndex) {
        taskRepository.removeTaskByOrderIndex(orderIndex);
    }*/

}

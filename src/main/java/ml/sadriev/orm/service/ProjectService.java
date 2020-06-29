package ml.sadriev.orm.service;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.api.repository.IProjectRepository;
import ml.sadriev.orm.api.service.IProjectService;
import ml.sadriev.orm.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrey Sadriev
 */
@Service
public class ProjectService implements IProjectService {

    private final IProjectRepository projectRepository;

    @Autowired
    public ProjectService(final IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.createProject(name);
    }

    @Override
    public Project merge(final Project project) {
        return projectRepository.merge(project);
    }

    @Override
    @Transactional
    public Project getProjectById(final String id) {
        return projectRepository.getProjectById(id);
    }

    @Override
    public void removeProjectById(final String id) {
        projectRepository.removeProjectById(id);
    }

    @Override
    @Transactional
    public List<Project> getListProject() {
        return projectRepository.getListProject();
    }

    @Override
    public void clear() {
        projectRepository.clear();
    }

    @Override
    public void merge(Project... projects) {
        projectRepository.merge(projects);
    }

    @Override
    @Transactional
    public void load(Collection<Project> projects) {
        projectRepository.load(projects);
    }

    @Override
    @Transactional
    public void load(Project... projects) {
        projectRepository.load(projects);
    }

    @Override
    public Project removeByOrderIndex(Integer orderIndex) {
        if (orderIndex == null) return null;
        return projectRepository.removeByOrderIndex(orderIndex);
    }
}
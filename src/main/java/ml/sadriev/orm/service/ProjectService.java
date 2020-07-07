package ml.sadriev.orm.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import ml.sadriev.orm.api.repository.ProjectRepository;
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

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.createProject(name);
    }

    @Override
    @Transactional
    public Project merge(final Project project) {
        return projectRepository.merge(project);
    }

    @Override
    public Project getProjectById(final String id) {
        return projectRepository.findProjectById(id);
    }

    @Override
    @Transactional
    public void removeProjectByName(final String name) {
        projectRepository.deleteProjectByName(name);
    }

    @Override
    public List<Project> getListProject() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public void clear() {
        projectRepository.deleteAll();
    }

    @Override
    @Transactional
    public void merge(Project... projects) {
        projectRepository.merge(projects);
    }

    @Override
    @Transactional
    public void load(Collection<Project> projects) {
        clear();
        projectRepository.load(projects);
    }

    @Override
    public void load(Project... projects) {
        clear();
        projectRepository.load(projects);
    }

    @Override
    @Transactional
    public Project removeByOrderIndex(Integer orderIndex) {
        if (orderIndex == null) return null;
        return projectRepository.removeByOrderIndex(orderIndex);
    }

    @Override
    public Project findProjectById(String id) {
        Optional<Project> projects = projectRepository.findById(id);
        return projects.orElse(new Project());
    }

    @Override
    public Set<String> findFirstThreeNamesFromProjectById(String... ids) {
        List<Project> projects = projectRepository.findAllById(Collections.unmodifiableList(Arrays.asList(ids)));
        return projects
                .stream()
                .limit(3)
                .map(Project::getName)
                .collect(Collectors.toSet());
    }
}
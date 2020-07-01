package ml.sadriev.orm.repository;

import java.util.Collection;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ml.sadriev.orm.api.repository.ProjectRepositoryCustom;
import ml.sadriev.orm.model.Project;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Project createProject(final String name) {
        final Project project = new Project();
        project.setName(name);
        entityManager.merge(project);
        return project;
    }

    @Override
    public Project merge(final Project project) {
        if (project == null) return null;
        entityManager.persist(project.getId());
        return project;
    }

    @Override
    public void merge(final Collection<Project> projects) {
        if (projects == null) return;
        for (final Project project : projects) {
            entityManager.merge(project);
        }
    }

    @Override
    public void merge(final Project... projects) {
        if (projects == null) return;
        for (final Project project : projects) {
            merge(project);
        }
    }

    @Override
    public void load(final Collection<Project> projects) {
        projects.forEach(entityManager::persist);
    }

    @Override
    public void load(final Project... projects) {
        Stream.of(projects).forEach(entityManager::persist);
    }

    @Override
    public Project removeByOrderIndex(Integer orderIndex) {
        return null;
    }
}

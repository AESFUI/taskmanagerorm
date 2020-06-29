package ml.sadriev.orm.api.repository;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrey Sadriev
 */
public interface IProjectRepository extends JpaRepository<Project, String> {

    Project createProject(String name);

    Project merge(Project project);

    void merge(Collection<Project> projects);

    void merge(Project... projects);

    void load(Collection<Project> projects);

    void load(Project... projects);

    Project getProjectById(String id);

    Project removeByOrderIndex(Integer orderIndex);

    void removeProjectById(String id);

    List<Project> getListProject();

    void clear();

}

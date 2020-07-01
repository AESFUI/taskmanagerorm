package ml.sadriev.orm.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ml.sadriev.orm.api.repository.ProjectRepository;
import ml.sadriev.orm.api.repository.ProjectRepositoryCustom;
import ml.sadriev.orm.model.Project;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * @author Andrey Sadriev
 */
@Component
public class ProjectRepositoryImpl implements ProjectRepository, ProjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<String, Project> map = new LinkedHashMap<>();

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
        clear();
        entityManager.persist(projects);
    }

    @Override
    public void load(final Project... projects) {
        clear();
        merge(projects);
    }

    @Override
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return map.get(id);
    }

    @Override
    public Project removeByOrderIndex(Integer orderIndex) {
        return null;
    }

    @Override
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }

    @Override
    public List<Project> getListProject() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public List<Project> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Project> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Project project) {

    }

    @Override
    public void deleteAll(Iterable<? extends Project> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Project> S save(S s) {
        return null;
    }

    @Override
    public <S extends Project> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Project> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Project> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Project> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Project getOne(String s) {
        return null;
    }

    @Override
    public <S extends Project> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Project> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Project> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Project> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Project> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Project> boolean exists(Example<S> example) {
        return false;
    }
}

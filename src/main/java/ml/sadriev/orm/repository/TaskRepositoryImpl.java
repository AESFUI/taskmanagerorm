package ml.sadriev.orm.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ml.sadriev.orm.api.repository.TaskRepository;
import ml.sadriev.orm.api.repository.TaskRepositoryCustom;
import ml.sadriev.orm.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Task getByOrderIndex(final Integer orderIndex) {
        if (orderIndex == null) return null;
        return getListTask().get(orderIndex);
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
        clear();
        merge(tasks);
    }

    @Override
    public void load(final Task... tasks) {
        clear();
        merge(tasks);
    }

    @Override
    public Task merge(final Task task) {
        if (task == null) return null;
        map.put(task.getId(), task);
        return task;
    }

    @Override
    public void removeTaskById(final String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }

    @Override
    public void removeTaskByOrderIndex(final Integer orderIndex) {
        Task task = getByOrderIndex(orderIndex);
        if (task == null) return;
        removeTaskById(task.getId());
    }

    @Override
    public List<Task> getListTask() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        entityManager.clear();
        map.clear();
    }

/*    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public List<Task> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Task> findAllById(Iterable<String> iterable) {
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
    public void delete(Task task) {

    }

    @Override
    public void deleteAll(Iterable<? extends Task> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Task> S save(S s) {
        return null;
    }

    @Override
    public <S extends Task> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Task> findById(String s) {
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
    public <S extends Task> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Task> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Task getOne(String s) {
        return null;
    }

    @Override
    public <S extends Task> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Task> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Task> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Task> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Task> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Task> boolean exists(Example<S> example) {
        return false;
    }*/
}

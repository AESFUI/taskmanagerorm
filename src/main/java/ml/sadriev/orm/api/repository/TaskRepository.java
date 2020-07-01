package ml.sadriev.orm.api.repository;

import java.util.Collection;
import java.util.List;
import ml.sadriev.orm.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrey Sadriev
 */
public interface TaskRepository extends JpaRepository<Task, String> {



}

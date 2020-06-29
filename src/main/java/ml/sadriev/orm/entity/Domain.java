package ml.sadriev.orm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Domain {

    private List<Project> projects = new ArrayList<>();

    private List<Task> tasks = new ArrayList<>();

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}

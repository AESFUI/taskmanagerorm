package ml.sadriev.orm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 * @author Andrey Sadriev
 */

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Domain {

    @Id
    @GeneratedValue
    private String id = UUID.randomUUID().toString();

    @OneToMany
    private List<Project> projects = new ArrayList<>();

    @OneToMany
    private List<Task> tasks = new ArrayList<>();
}

package ml.sadriev.orm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author Andrey Sadriev
 */

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Task implements Serializable{

    @Id
    private String id = UUID.randomUUID().toString();

    private String projectId;

    private String name = "";

    private Date dateBegin;

    private Date dateEnd;
}

package ml.sadriev.orm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author Andrey Sadriev
 */

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Project implements Serializable {

    @Id
    @GeneratedValue
    private String id = UUID.randomUUID().toString();

    private String name = "";

    private Date dateBegin;

    private Date dateEnd;

    private Date created = new Date();
}

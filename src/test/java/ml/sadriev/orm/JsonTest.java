package ml.sadriev.orm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import ml.sadriev.orm.model.Project;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrey Sadriev
 */
public class JsonTest {

    @Test
    public void test() throws JsonProcessingException {
        final Project project = new Project();
        project.setName("2334");

        final List<Project> projects = Arrays.asList(project, project);

        final ObjectMapper objectMapper = new ObjectMapper();
//        final ObjectMapper objectMapper = new XmlMapper();
//        System.out.println(objectMapper.writeValueAsString(projects));
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(projects));
    }

    @Test
    public void test2() throws IOException {
        final String json = "{ \"id\": \"234\", \"Name\": \"455\", \"id2\": \"234\" }";
        final ObjectMapper objectMapper = new ObjectMapper();
        final Project project = objectMapper.readValue(json, Project.class);
        project.hashCode();
    }

}

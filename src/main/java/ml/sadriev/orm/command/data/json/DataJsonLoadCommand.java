package ml.sadriev.orm.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import javax.annotation.Resource;
import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.constant.DataConstant;
import ml.sadriev.orm.entity.Domain;
import ml.sadriev.orm.service.DomainService;
import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataJsonLoadCommand extends AbstractCommand {

    @Resource
    private DomainService domainService;

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "Load Domain from JSON.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[LOAD JSON DATA]");
        final File file = new File(DataConstant.FILE_JSON);
        if (!exists(file)) return;
        final byte[] bytes = Files.readAllBytes(file.toPath());
        final String json = new String(bytes, "UTF-8");
        final ObjectMapper objectMapper = new ObjectMapper();
        final Domain domain = objectMapper.readValue(json, Domain.class);
        domainService.load(domain);
        System.out.println("[OK]");
    }

    private boolean exists(final File file) {
        if (file == null) return false;
        final boolean check = file.exists();
        if (!check) System.out.println("FILE NOT FOUND");
        return check;
    }

}

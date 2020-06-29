package ml.sadriev.orm.command.data.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
public final class DataXmlSaveCommand extends AbstractCommand {

    @Resource
    private DomainService domainService;

    @Override
    public String command() {
        return "data-xml-save";
    }

    @Override
    public String description() {
        return "Save Domain to XML.";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA XML SAVE]");
        final Domain domain = new Domain();
        domainService.export(domain);
        final ObjectMapper objectMapper = new XmlMapper();
        final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        final String json = objectWriter.writeValueAsString(domain);
        final byte[] data = json.getBytes("UTF-8");
        final File file = new File(DataConstant.FILE_XML);
        Files.write(file.toPath(), data);
        System.out.println("[OK]");
    }

}

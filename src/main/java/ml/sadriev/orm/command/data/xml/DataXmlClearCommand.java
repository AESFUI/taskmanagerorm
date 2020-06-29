package ml.sadriev.orm.command.data.xml;

import ml.sadriev.orm.command.AbstractCommand;
import ml.sadriev.orm.constant.DataConstant;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataXmlClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "Remove XML file.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_XML);
        Files.deleteIfExists(file.toPath());
    }

}
